package com.semihbkgr.website.controller;

import com.semihbkgr.website.service.CategoryService;
import com.semihbkgr.website.service.PostService;
import com.semihbkgr.website.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class AppController {

    private final SubjectService subjectService;
    private final CategoryService categoryService;
    private final PostService postService;

    @GetMapping("/")
    public Mono<String> home(Model model) {
        return subjectService.findAll()
                .collectList()
                .doOnNext(subjects -> model.addAttribute("subjects", subjects))
                .flatMapMany(subjects -> Flux.fromIterable(subjects)
                        .flatMap(subject -> postService
                                .findLastInfos(subject.getId())))
                .collectList()
                .doOnNext(postInfos -> model.addAttribute("postInfos", postInfos))
                .thenReturn("home")
                .doOnTerminate(()->model.addAttribute("isHomePage",true));
    }

    @GetMapping("/{url-endpoint}")
    public Mono<String> subject(@PathVariable("url-endpoint") String urlEndpoint, Model model) {
        return subjectService.find(urlEndpoint)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .doOnNext(subject -> model.addAttribute("currentSubject", subject))
                .flatMap(subject -> categoryService
                        .findAllBySubjectId(subject.getId())
                        .collectList()
                        .doOnNext(categories -> model.addAttribute("categories", categories))
                        .thenMany(postService.findAllInfos(subject.getId()))
                        .collectList()
                        .doOnNext(postInfos -> model.addAttribute("postInfos", postInfos)))
                .thenMany(subjectService.findAll())
                .collectList()
                .doOnNext(subjects -> model.addAttribute("subjects", subjects))
                .thenReturn("subject");
    }

    @GetMapping("/{subject-url-endpoint}/{post-url-endpoint}")
    public Mono<String> post(@PathVariable("subject-url-endpoint") String subjectUrlEndpoint,
                             @PathVariable("post-url-endpoint") String postUrlEndpoint, Model model) {
        return postService.find(subjectUrlEndpoint, postUrlEndpoint)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .doOnNext(post -> model.addAttribute("post", post))
                .flatMap(post -> subjectService.find(post.getSubjectId()))
                .doOnNext(subject -> model.addAttribute("currentSubject", subject))
                .thenMany(subjectService.findAll())
                .collectList()
                .doOnNext(subjects -> model.addAttribute("subjects", subjects))
                .thenReturn("post");
    }

    @GetMapping("/about")
    public Mono<String> about(Model model) {
        return subjectService.findAll()
                .collectList()
                .doOnNext(subjects -> model.addAttribute("subjects", subjects))
                .thenReturn("about");
    }

}
