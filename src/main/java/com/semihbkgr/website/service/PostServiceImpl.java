package com.semihbkgr.website.service;

import com.semihbkgr.website.model.Post;
import com.semihbkgr.website.model.dto.PostInfo;
import com.semihbkgr.website.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;


    @Override
    public Mono<Post> find(String subjectUrl, String postUrl) {
        return postRepository.findBySubjectUrlEndpointAndPostUrlEndpoint(subjectUrl,postUrl);
    }

    @Override
    public Flux<PostInfo> findLastInfos(int subjectId) {
        return postRepository.findTop3BySubjectIdOrderByCreateTimeDesc(subjectId);
    }

    @Override
    public Flux<PostInfo> findAllInfos(int subjectId) {
        return postRepository.findAllBySubjectIdOrderByDisplayOrderAsc(subjectId);
    }

}
