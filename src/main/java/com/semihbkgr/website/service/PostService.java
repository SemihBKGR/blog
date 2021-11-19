package com.semihbkgr.website.service;

import com.semihbkgr.website.model.Post;
import com.semihbkgr.website.model.dto.PostInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

    Mono<Post> find(String subjectUrl, String postUrl);

    Flux<PostInfo> findLastInfos(int subjectId);

    Flux<PostInfo> findAllInfos(int subjectId);

}
