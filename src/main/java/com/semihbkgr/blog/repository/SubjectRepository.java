package com.semihbkgr.blog.repository;

import com.semihbkgr.blog.model.Subject;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubjectRepository extends R2dbcRepository<Subject, Integer> {

    Mono<Subject> findByUrlEndpoint(String urlEndpoint);

    Flux<Subject> findAllByOrderByDisplayOrderAsc();

}
