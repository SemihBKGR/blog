package com.semihbkgr.website.service;

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
class SubjectServiceImplTest {

    @Autowired
    SubjectServiceImpl subjectService;

    @BeforeAll
    static void init() {
        Loggers.useSl4jLoggers();
    }

    @Test
    @DisplayName("Find existing subject by id")
    void findExistingSubjectById() {
        final var subjectId = 1;
        log.info("SubjectId: {}", subjectId);
        var subjectMono = subjectService.find(subjectId).log();
        StepVerifier.create(subjectMono)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find non-existing subject by id")
    void findNonExistingSubjectById() {
        final var subjectId = 4;
        log.info("SubjectId: {}", subjectId);
        var subjectMono = subjectService.find(subjectId).log();
        StepVerifier.create(subjectMono)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find existing subject by url endpoint")
    void findExistingSubjectByUrlEndpoint() {
        final var urlEndpoint = "subject-01";
        log.info("UrlEndpoint: {}", urlEndpoint);
        var subjectMono = subjectService.find(urlEndpoint).log();
        StepVerifier.create(subjectMono)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find non-existing subject by url endpoint")
    void findNonExistingSubjectByUrlEndpoint() {
        final var urlEndpoint = "subject-01";
        log.info("UrlEndpoint: {}", urlEndpoint);
        var subjectMono = subjectService.find(urlEndpoint).log();
        StepVerifier.create(subjectMono)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void findAll() {
        var subjectFlux = subjectService.findAll();
        StepVerifier.create(subjectFlux)
                .expectNextCount(3)
                .verifyComplete();
    }

}