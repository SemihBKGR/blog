package com.semihbkgr.blog.service;

import com.semihbkgr.blog.model.Post;
import com.semihbkgr.blog.model.dto.PostInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

    Mono<Post> find(String subjectUrl, String postUrl);

    Flux<PostInfo> findLastInfos(int subjectId);

    Flux<PostInfo> findAllInfos(int subjectId);

}
