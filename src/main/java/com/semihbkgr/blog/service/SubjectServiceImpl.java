package com.semihbkgr.blog.service;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.semihbkgr.blog.model.Subject;
import com.semihbkgr.blog.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import reactor.cache.CacheFlux;
import reactor.cache.CacheMono;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;

import java.util.List;

@Service
@SuppressWarnings("rawtypes")
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final Cache<Object, Signal> cacheOne;
    private final Cache<Object, List> cacheAll;
    private final Object emptyArgKey;

    public SubjectServiceImpl(SubjectRepository subjectRepository, Caffeine<Object, Object> caffeine) {
        this.subjectRepository = subjectRepository;
        this.cacheOne = caffeine.build();
        this.cacheAll = caffeine.build();
        this.emptyArgKey = new Object();
    }

    @Override
    public Mono<Subject> find(int id) {
        return CacheMono.lookup(cacheOne.asMap(), id, Subject.class)
                .onCacheMissResume(() -> subjectRepository.findById(id));
    }

    @Override
    public Mono<Subject> find(String urlEndpoint) {
        return CacheMono.lookup(cacheOne.asMap(), urlEndpoint, Subject.class)
                .onCacheMissResume(() -> subjectRepository.findByUrlEndpoint(urlEndpoint));
    }

    @Override
    public Flux<Subject> findAll() {
        return CacheFlux.lookup(cacheAll.asMap(), emptyArgKey, Subject.class)
                .onCacheMissResume(subjectRepository::findAllByOrderByDisplayOrderAsc);
    }

}
