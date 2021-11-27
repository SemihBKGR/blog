package com.semihbkgr.blog.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import reactor.test.StepVerifier;
import reactor.util.Loggers;

// Make sure that you have already executed ddl and dml script files before testing
@Slf4j
@DataR2dbcTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @BeforeAll
    static void init() {
        Loggers.useSl4jLoggers();
    }

    @Test
    @DisplayName("Find by existing subject url endpoint and post url endpoint")
    void findByExistingSubjectUrlEndpointAndPostUrlEndpoint() {
        final var subjectUrlEndpoint = "subject-01";
        final var postUrlEndpoint = "post-01";
        log.info("SubjectUrlEndpoint: {}, PostUrlEndpoint: {}", subjectUrlEndpoint, postUrlEndpoint);
        var postMono = postRepository.findBySubjectUrlEndpointAndPostUrlEndpoint(subjectUrlEndpoint, postUrlEndpoint).log();
        StepVerifier.create(postMono)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find by non-existing subject url endpoint and post url endpoint")
    void findByNonExistingSubjectUrlEndpointAndPostUrlEndpoint() {
        final var subjectUrlEndpoint = "subject-01";
        final var postUrlEndpoint = "post-02";
        log.info("SubjectUrlEndpoint: {}, PostUrlEndpoint: {}", subjectUrlEndpoint, postUrlEndpoint);
        var postMono = postRepository.findBySubjectUrlEndpointAndPostUrlEndpoint(subjectUrlEndpoint, postUrlEndpoint).log();
        StepVerifier.create(postMono)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find top 3 by existing subject id order by create time desc")
    void findTop3ByExistingSubjectIdOrderByCreateTimeDesc() {
        final var subjectId = 1;
        log.info("SubjectId: {}", subjectId);
        var postFlux = postRepository.findTop3BySubjectIdOrderByCreateTimeDesc(subjectId).log();
        StepVerifier.create(postFlux)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find top 3 by non-existing subject id order by create time desc")
    void findTop3ByNonExistingSubjectIdOrderByCreateTimeDesc() {
        final var subjectId = 4;
        log.info("SubjectId: {}", subjectId);
        var postFlux = postRepository.findTop3BySubjectIdOrderByCreateTimeDesc(subjectId).log();
        StepVerifier.create(postFlux)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find all by existing subject id order by display order asc")
    void findAllByExistingSubjectIdOrderByDisplayOrderAsc() {
        final var subjectId = 1;
        log.info("SubjectId: {}", subjectId);
        var postFlux = postRepository.findAllBySubjectIdOrderByDisplayOrderAsc(subjectId).log();
        StepVerifier.create(postFlux)
                .expectNextCount(9)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find all by non-existing subject id order by display order asc")
    void findAllByNonExistingSubjectIdOrderByDisplayOrderAsc() {
        final var subjectId = 4;
        log.info("SubjectId: {}", subjectId);
        var postFlux = postRepository.findAllBySubjectIdOrderByDisplayOrderAsc(subjectId).log();
        StepVerifier.create(postFlux)
                .verifyComplete();
    }

}