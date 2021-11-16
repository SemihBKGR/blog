package com.semihbkgr.website.repository;

import com.semihbkgr.website.model.Post;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface PostRepository extends R2dbcRepository<Post,Integer> {

    Mono<Post> findByTitle(String title);

}
