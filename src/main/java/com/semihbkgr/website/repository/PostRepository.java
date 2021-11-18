package com.semihbkgr.website.repository;

import com.semihbkgr.website.model.Post;
import com.semihbkgr.website.model.dto.PostInfo;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostRepository extends R2dbcRepository<Post, Integer> {

    Mono<Post> findByTitle(String title);

    @Query("SELECT `posts`.`id`,`subjects`.`id` as `subject_id`,`tags`.`id` as `tag_id`, `posts`.`title`, `posts`.`create_time` " +
            "FROM `subjects` INNER JOIN `tags` ON `tags`.`subject_id` = `subjects`.`id` INNER JOIN `posts` ON `posts`.`tag_id` = `tags`.`id`" +
            "WHERE `subjects`.`id` = ? ORDER BY `posts`.`create_time` DESC LIMIT 3 OFFSET 0")
    Flux<PostInfo> findLast3PostInfosBySubjectId(int subjectId);

    @Query("SELECT `posts`.`id`,`subjects`.`id` as `subject_id`,`tags`.`id` as `tag_id`, `posts`.`title`, `posts`.`create_time` " +
            "FROM `subjects` INNER JOIN `tags` ON `tags`.`subject_id` = `subjects`.`id` INNER JOIN `posts` ON `posts`.`tag_id` = `tags`.`id`" +
            "WHERE `subjects`.`id` = ? ORDER BY `subjects`.`display_order`")
    Flux<PostInfo> findAllPostInfosBySubjectId(int subjectId);

}
