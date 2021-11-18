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
    public Mono<Post> findByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    public Flux<PostInfo> findLast3PostInfosBySubjectId(int subjectId) {
        return postRepository.findLast3PostInfosBySubjectId(subjectId);
    }

    @Override
    public Flux<PostInfo> findAllPostInfosBySubjectId(int subjectId) {
        return postRepository.findAllPostInfosBySubjectId(subjectId);
    }

}
