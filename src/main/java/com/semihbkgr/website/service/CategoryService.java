package com.semihbkgr.website.service;

import com.semihbkgr.website.model.Category;
import reactor.core.publisher.Flux;

public interface CategoryService {

    Flux<Category> findAllBySubjectId(int subjectId);

}
