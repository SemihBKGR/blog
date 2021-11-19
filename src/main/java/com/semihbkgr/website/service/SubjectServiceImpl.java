package com.semihbkgr.website.service;

import com.semihbkgr.website.model.Subject;
import com.semihbkgr.website.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public Mono<Subject> find(int id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Mono<Subject> find(String urlEndpoint) {
        return subjectRepository.findByUrlEndpoint(urlEndpoint);
    }

    @Override
    public Flux<Subject> findAll() {
        return subjectRepository.findAllByOrderByDisplayOrderAsc();
    }

}
