package com.semihbkgr.website.controller;

import com.semihbkgr.website.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{title}")
    public Mono<String> post(@PathVariable("title") String title, Model model) {
        return postService.findByTitle(title)
                .map(post -> {
                    model.addAttribute("post", post);
                    return "post";
                })
                .switchIfEmpty(
                        Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Post was not found")));
    }

}
