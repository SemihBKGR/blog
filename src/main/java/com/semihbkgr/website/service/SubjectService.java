package com.semihbkgr.website.service;

import com.semihbkgr.website.model.Subject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubjectService {

    Mono<Subject> find(String urlEndpoint);

    Flux<Subject> findAll();

}
