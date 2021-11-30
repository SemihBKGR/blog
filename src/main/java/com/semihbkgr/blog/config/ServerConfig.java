package com.semihbkgr.blog.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Configuration
public class ServerConfig {

    private static final String SCHEME = "https";

    private final WebServer redirectionServer;

    public ServerConfig(@Value("${server.port}") int port, @Value("${server.redirection.port:0}") int redirectionPort) {
        if (redirectionPort > 0) {
            NettyReactiveWebServerFactory httpNettyReactiveWebServerFactory = new NettyReactiveWebServerFactory(redirectionPort);
            this.redirectionServer = httpNettyReactiveWebServerFactory.getWebServer((request, response) -> {
                URI uri = request.getURI();
                URI httpsUri;
                try {
                    httpsUri = new URI(SCHEME, uri.getUserInfo(), uri.getHost(), port, uri.getPath(), uri.getQuery(), uri.getFragment());
                } catch (URISyntaxException e) {
                    return Mono.error(e);
                }
                response.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
                response.getHeaders().setLocation(httpsUri);
                return response.setComplete();
            });
        } else
            this.redirectionServer = null;
    }

    @PostConstruct
    public void startRedirectionServer() {
        if (redirectionServer != null) {
            redirectionServer.start();
            log.info("Redirection server has been started successfully");
        }
    }

    @PreDestroy
    public void stopRedirectionServer() {
        if (redirectionServer != null) {
            redirectionServer.stop();
            log.info("Redirection server has been stopped successfully");
        }
    }

}
