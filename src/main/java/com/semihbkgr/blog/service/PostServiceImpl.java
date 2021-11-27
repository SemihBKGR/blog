package com.semihbkgr.blog.service;

import com.semihbkgr.blog.model.Post;
import com.semihbkgr.blog.model.dto.PostInfo;
import com.semihbkgr.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;


    @Override
    public Mono<Post> find(String subjectUrlEndpoint, String postUrlEndpoint) {
        return postRepository.findBySubjectUrlEndpointAndPostUrlEndpoint(subjectUrlEndpoint,postUrlEndpoint);
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
