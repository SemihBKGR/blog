package com.semihbkgr.website.service;

import com.semihbkgr.website.model.Post;
import reactor.core.publisher.Mono;

public interface PostService {

    Mono<Post> findByTitle(String title);

}
