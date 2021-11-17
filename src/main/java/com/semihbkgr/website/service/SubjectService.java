package com.semihbkgr.website.service;

import com.semihbkgr.website.model.Subject;
import reactor.core.publisher.Flux;

public interface SubjectService {

    Flux<Subject> findAll();

}
