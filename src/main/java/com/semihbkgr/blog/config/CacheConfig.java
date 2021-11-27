package com.semihbkgr.blog.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Slf4j
@Configuration
public class CacheConfig {

    @Bean
    public Caffeine<Object, Object> caffeine(@Value("${cache.expiration.duration}") Duration duration) {
        log.info("Cache expiration duration: {}", duration);
        return Caffeine.newBuilder().expireAfterWrite(duration);
    }

}
