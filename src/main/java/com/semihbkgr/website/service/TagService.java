package com.semihbkgr.website.service;

import com.semihbkgr.website.model.Tag;
import reactor.core.publisher.Flux;

public interface TagService {

    Flux<Tag> findAllBySubjectId(int subjectId);

}
