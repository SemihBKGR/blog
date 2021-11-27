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
class SubjectRepositoryTest {

    @Autowired
    SubjectRepository subjectRepository;

    @BeforeAll
    static void init() {
        Loggers.useSl4jLoggers();
    }

    @Test
    @DisplayName("Find by existing url endpoint")
    void findByExistingUrlEndpoint() {
        final var urlEndpoint = "subject-01";
        log.info("UrlEndpoint: {}", urlEndpoint);
        var subjectMono = subjectRepository.findByUrlEndpoint(urlEndpoint).log();
        StepVerifier.create(subjectMono)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find by non-existing url endpoint")
    void findByNonExistingUrlEndpoint() {
        final var urlEndpoint = "subject-04";
        log.info("UrlEndpoint: {}", urlEndpoint);
        var subjectMono = subjectRepository.findByUrlEndpoint(urlEndpoint).log();
        StepVerifier.create(subjectMono)
                .verifyComplete();
    }

    @Test
    @DisplayName("Find all by order by display order asc")
    void findAllByOrderByDisplayOrderAsc() {
        var subjectFlux = subjectRepository.findAllByOrderByDisplayOrderAsc().log();
        StepVerifier.create(subjectFlux)
                .expectNextCount(3)
                .verifyComplete();
    }

}