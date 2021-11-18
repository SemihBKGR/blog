package com.semihbkgr.website.repository;

import com.semihbkgr.website.model.Post;
import com.semihbkgr.website.model.dto.PostInfo;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostRepository extends R2dbcRepository<Post, Integer> {

    Mono<Post> findByTitle(String title);

    @Query("SELECT `posts`.`id`,\n" +
            "       `subjects`.id as `subject_id`,\n" +
            "       `posts`.`title`,\n" +
            "       `posts`.`create_time`\n" +
            "FROM `subjects`\n" +
            "         INNER JOIN `tags` ON `tags`.`subject_id` = `subjects`.`id`\n" +
            "         INNER JOIN `posts` ON `posts`.`tag_id` = `tags`.`id`\n" +
            "WHERE `subjects`.`name` = ?\n" +
            "ORDER BY `create_time` DESC\n" +
            "LIMIT 3 OFFSET 0")
    Flux<PostInfo> findLast3PostInfos(String subjectName);

}
