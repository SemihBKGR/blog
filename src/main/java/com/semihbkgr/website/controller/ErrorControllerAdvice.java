package com.semihbkgr.website.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(ResponseStatusException.class)
    public Mono<String> handleResponseStatus(ResponseStatusException ex) {
        return Mono.just("error");
    }

}
