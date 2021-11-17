package com.semihbkgr.website.repository;

import com.semihbkgr.website.model.Tag;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface TagRepository extends R2dbcRepository<Tag,Integer> {

    Flux<Tag> findAllBySubjectIdOrderByDisplayOrderAsc(int subjectId);

}
