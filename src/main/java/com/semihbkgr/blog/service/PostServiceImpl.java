package com.semihbkgr.blog.service;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.semihbkgr.blog.model.Post;
import com.semihbkgr.blog.model.dto.PostInfo;
import com.semihbkgr.blog.repository.PostRepository;
import org.springframework.stereotype.Service;
import reactor.cache.CacheFlux;
import reactor.cache.CacheMono;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;

import java.util.List;

@Service
@SuppressWarnings("rawtypes")
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final Cache<String, Signal> cacheOne;
    private final Cache<Integer, List> cacheLast;
    private final Cache<Integer, List> cacheAll;

    public PostServiceImpl(PostRepository postRepository, Caffeine<Object, Object> caffeine) {
        this.postRepository = postRepository;
        this.cacheOne = caffeine.build();
        this.cacheLast = caffeine.build();
        this.cacheAll = caffeine.build();
    }

    @Override
    public Mono<Post> find(String subjectUrlEndpoint, String postUrlEndpoint) {
        return CacheMono.lookup(cacheOne.asMap(), subjectUrlEndpoint + postUrlEndpoint, Post.class)
                .onCacheMissResume(() -> postRepository.findBySubjectUrlEndpointAndPostUrlEndpoint(subjectUrlEndpoint, postUrlEndpoint));
    }

    @Override
    public Flux<PostInfo> findLastInfos(int subjectId) {
        return CacheFlux.lookup(cacheLast.asMap(), subjectId, PostInfo.class)
                .onCacheMissResume(() -> postRepository.findTop3BySubjectIdOrderByCreateTimeDesc(subjectId));
    }

    @Override
    public Flux<PostInfo> findAllInfos(int subjectId) {
        return CacheFlux.lookup(cacheAll.asMap(), subjectId, PostInfo.class)
                .onCacheMissResume(() -> postRepository.findAllBySubjectIdOrderByDisplayOrderAsc(subjectId));
    }

}
