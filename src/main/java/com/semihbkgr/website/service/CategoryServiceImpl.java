package com.semihbkgr.website.service;

import com.semihbkgr.website.model.Category;
import com.semihbkgr.website.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Flux<Category> findAllBySubjectId(int subjectId) {
        return categoryRepository.findAllBySubjectId(subjectId).cache();
    }

}
