package com.semihbkgr.website.service;

import com.semihbkgr.website.model.Post;
import com.semihbkgr.website.model.dto.PostInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

    Mono<Post> findByTitle(String title);

    Flux<PostInfo> findLast3PostInfos(String subjectName);

}
