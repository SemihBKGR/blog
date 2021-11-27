package com.semihbkgr.blog.service;

import com.semihbkgr.blog.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.Loggers;

// Make sure that you have already executed ddl and dml script files before testing
@Slf4j
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    CategoryServiceImpl categoryService;

    @BeforeAll
    static void init() {
        Loggers.useSl4jLoggers();
    }

    @Test
    @DisplayName("Find all categories by existing subject id")
    void findAllBySubjectIdByExistingSubjectId() {
        final var subjectId = 1;
        log.info("SubjectId: {}", subjectId);
        var categoryFlux = categoryService.findAllBySubjectId(subjectId).log();
        StepVerifier.create(categoryFlux)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find all categories by non-exsiting subject id")
    void findAllBySubjectIdByNonExistingSubjectId() {
        final var subjectId = 4;
        log.info("SubjectId: {}", subjectId);
        Flux<Category> categoryFlux = categoryService.findAllBySubjectId(subjectId).log();
        StepVerifier.create(categoryFlux)
                .verifyComplete();
    }

}