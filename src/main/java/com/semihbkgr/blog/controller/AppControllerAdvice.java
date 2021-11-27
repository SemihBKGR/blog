package com.semihbkgr.blog.controller;

import com.semihbkgr.blog.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@ControllerAdvice
@RequiredArgsConstructor
public class AppControllerAdvice {

    private final SubjectService subjectService;

    @ExceptionHandler(ResponseStatusException.class)
    public Mono<String> handleResponseStatus(ResponseStatusException ex, Model model) {
        return subjectService.findAll()
                .collectList()
                .doOnNext(subjects -> model.addAttribute("subjects", subjects))
                .thenReturn("error");
    }

}
