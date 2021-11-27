package com.semihbkgr.blog.repository;

import com.semihbkgr.blog.model.Post;
import com.semihbkgr.blog.model.dto.PostInfo;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostRepository extends R2dbcRepository<Post, Integer> {

    @Query("SELECT `posts`.* FROM `posts` INNER JOIN `subjects` ON `posts`.`subject_id` = `subjects`.`id` WHERE  `subjects`.`url_endpoint` = ? AND `posts`.`url_endpoint` = ?")
    Mono<Post> findBySubjectUrlEndpointAndPostUrlEndpoint(String subjectUrlEndpoint, String postUrlEndpoint);

    Flux<PostInfo> findTop3BySubjectIdOrderByCreateTimeDesc(int subjectId);

    Flux<PostInfo> findAllBySubjectIdOrderByDisplayOrderAsc(int subjectId);

}
