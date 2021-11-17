package com.semihbkgr.website.controller;

import com.semihbkgr.website.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final SubjectService subjectService;

    @GetMapping("/")
    public Mono<String> home(Model model) {
        return subjectService.findAll()
                .collectList()
                .map(subjects -> {
                    model.addAttribute("subjects", subjects);
                    return "home";
                });
    }

}
