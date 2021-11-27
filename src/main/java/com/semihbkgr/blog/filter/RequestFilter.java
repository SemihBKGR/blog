package com.semihbkgr.blog.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@Slf4j(topic = "request")
public class RequestFilter implements WebFilter {

    @NonNull
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, @NonNull WebFilterChain chain) {
        if (!exchange.getRequest().getPath().toString().startsWith("/static"))
            log.info("URI: {}", exchange.getRequest().getURI());
        return chain.filter(exchange);
    }

}
