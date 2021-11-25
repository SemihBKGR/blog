package com.semihbkgr.website.repository;

import com.semihbkgr.website.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.Loggers;

// Make sure that you have already executed ddl and dml script files before testing
@Slf4j
@DataR2dbcTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @BeforeAll
    static void init() {
        Loggers.useSl4jLoggers();
    }

    @Test
    @DisplayName("Find all categories by existing subject id")
    void findAllBySubjectIdByExistingSubjectId() {
        final var subjectId = 1;
        log.info("SubjectId: {}", subjectId);
        var categoryFlux = categoryRepository.findAllBySubjectId(subjectId).log();
        StepVerifier.create(categoryFlux)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find all categories by non-exsiting subject id")
    void findAllBySubjectIdByNonExistingSubjectId() {
        final var subjectId = 4;
        log.info("SubjectId: {}", subjectId);
        Flux<Category> categoryFlux = categoryRepository.findAllBySubjectId(subjectId).log();
        StepVerifier.create(categoryFlux)
                .verifyComplete();
    }

}