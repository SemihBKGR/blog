package com.semihbkgr.blog.service;

import com.semihbkgr.blog.model.Category;
import reactor.core.publisher.Flux;

public interface CategoryService {

    Flux<Category> findAllBySubjectId(int subjectId);

}
