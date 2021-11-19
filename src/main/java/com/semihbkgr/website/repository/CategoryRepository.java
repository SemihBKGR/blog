package com.semihbkgr.website.repository;

import com.semihbkgr.website.model.Category;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CategoryRepository extends R2dbcRepository<Category,Integer> {

    @Query("SELECT DISTINCT `categories`.* FROM `posts` INNER JOIN `categories` ON `posts`.`category_id` = `categories`.`id` WHERE `posts`.`subject_id` = ? ORDER BY `categories`.`display_order`")
    Flux<Category> findAllBySubjectId(int subjectId);

}
