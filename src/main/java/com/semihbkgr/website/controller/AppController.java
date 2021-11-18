package com.semihbkgr.website.controller;

import com.semihbkgr.website.service.PostService;
import com.semihbkgr.website.service.SubjectService;
import com.semihbkgr.website.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class AppController {

    private final SubjectService subjectService;
    private final TagService tagService;
    private final PostService postService;

    @GetMapping("/")
    public Mono<String> home(Model model) {
        return subjectService.findAll()
                .collectList()
                .doOnNext(subjects -> model.addAttribute("subjects", subjects))
                .flatMapMany(subjects -> Flux.fromIterable(subjects)
                        .flatMap(subject -> postService
                                .findLast3PostInfosBySubjectId(subject.getId())))
                .collectList()
                .doOnNext(postInfos -> model.addAttribute("postInfos", postInfos))
                .thenReturn("home");
    }

    @GetMapping("/{url-endpoint}")
    public Mono<String> subject(@PathVariable("url-endpoint") String urlEndpoint, Model model) {
        return subjectService.findByUrlEndpoint(urlEndpoint)
                .doOnNext(subject -> model.addAttribute("currentSubject", subject))
                .flatMap(subject -> tagService
                        .findAllBySubjectId(subject.getId())
                        .collectList()
                        .doOnNext(tags -> model.addAttribute("tags", tags))
                        .thenMany(postService.findAllPostInfosBySubjectId(subject.getId()))
                        .collectList()
                        .doOnNext(postInfos -> model.addAttribute("postInfos", postInfos)))
                .thenMany(subjectService.findAll())
                .collectList()
                .doOnNext(subjects -> model.addAttribute("subjects", subjects))
                .thenReturn("subject");
    }

    @GetMapping("/about")
    public Mono<String> about() {
        return Mono.just("about");
    }

}
