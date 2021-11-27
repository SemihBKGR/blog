package com.semihbkgr.blog.service;

import com.semihbkgr.blog.model.Subject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubjectService {

    Mono<Subject> find(int id);

    Mono<Subject> find(String urlEndpoint);

    Flux<Subject> findAll();

}
