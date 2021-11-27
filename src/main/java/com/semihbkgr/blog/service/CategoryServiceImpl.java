package com.semihbkgr.blog.service;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.semihbkgr.blog.model.Category;
import com.semihbkgr.blog.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import reactor.cache.CacheFlux;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@SuppressWarnings("rawtypes")
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final Cache<Integer, List> cache;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Caffeine<Object, Object> caffeine) {
        this.categoryRepository = categoryRepository;
        this.cache = caffeine.build();
    }

    @Override
    public Flux<Category> findAllBySubjectId(int subjectId) {
        return CacheFlux.lookup(cache.asMap(), subjectId, Category.class)
                .onCacheMissResume(() -> categoryRepository.findAllBySubjectId(subjectId));
    }

}
