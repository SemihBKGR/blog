package com.semihbkgr.blog.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;
import reactor.util.Loggers;

// Make sure that you have already executed ddl and dml script files before testing
@Slf4j
@SpringBootTest
class PostServiceImplTest {

    @Autowired
    PostServiceImpl postService;

    @BeforeAll
    static void init() {
        Loggers.useSl4jLoggers();
    }

    @Test
    @DisplayName("Find existing post")
    void findExistingPost() {
        final var subjectUrlEndpoint = "subject-01";
        final var postUrlEndpoint = "post-01";
        log.info("SubjectUrlEndpoint: {}, PostUrlEndpoint: {}", subjectUrlEndpoint, postUrlEndpoint);
        var postMono = postService.find(subjectUrlEndpoint, postUrlEndpoint).log();
        StepVerifier.create(postMono)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find non-existing post")
    void findNonExistingPost() {
        final var subjectUrlEndpoint = "subject-01";
        final var postUrlEndpoint = "post-02";
        log.info("SubjectUrlEndpoint: {}, PostUrlEndpoint: {}", subjectUrlEndpoint, postUrlEndpoint);
        var postMono = postService.find(subjectUrlEndpoint, postUrlEndpoint).log();
        StepVerifier.create(postMono)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find existing last infos")
    void findLastInfos() {
        final var subjectId = 1;
        log.info("SubjectId: {}", subjectId);
        var postFlux = postService.findLastInfos(subjectId).log();
        StepVerifier.create(postFlux)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find non-existing last infos")
    void findNonLastInfos() {
        final var subjectId = 4;
        log.info("SubjectId: {}", subjectId);
        var postFlux = postService.findLastInfos(subjectId).log();
        StepVerifier.create(postFlux)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find all existing infos")
    void findAllExistingInfos() {
        final var subjectId = 1;
        log.info("SubjectId: {}", subjectId);
        var postFlux = postService.findLastInfos(subjectId).log();
        StepVerifier.create(postFlux)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find all non-existing infos")
    void findAllNonExistingInfos() {
        final var subjectId = 4;
        log.info("SubjectId: {}", subjectId);
        var postFlux = postService.findLastInfos(subjectId).log();
        StepVerifier.create(postFlux)
                .verifyComplete();
    }

}