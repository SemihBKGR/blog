package com.semihbkgr.blog.controller;

import com.semihbkgr.blog.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("${server.error.path}")
@RequiredArgsConstructor
public class AppErrorController implements ErrorController {

    private final SubjectService subjectService;

    @GetMapping("/")
    public Mono<String> error(Model model) {
        return subjectService.findAll()
                .collectList()
                .doOnNext(subjects -> model.addAttribute("subjects", subjects))
                .thenReturn("error");
    }

}
