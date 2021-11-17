package com.semihbkgr.website.controller;

import com.semihbkgr.website.service.PostService;
import com.semihbkgr.website.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final SubjectService subjectService;
    private final PostService postService;

    @GetMapping("/")
    public Mono<String> home(Model model) {
        return subjectService.findAll()
                .collectList()
                .flatMapMany(subjects -> {
                    model.addAttribute("subjects", subjects);
                    return Flux.fromIterable(subjects)
                            .map(subject -> postService.findByTitle(subject.getName()));
                })
                .collectList()
                .doOnNext(posts -> model.addAttribute("posts", posts))
                .thenReturn("home");
    }

}
