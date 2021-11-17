package com.semihbkgr.website.repository;

import com.semihbkgr.website.model.Subject;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface SubjectRepository extends R2dbcRepository<Subject, Integer> {

    Flux<Subject> findAllByOrderByDisplayOrderAsc();

}
