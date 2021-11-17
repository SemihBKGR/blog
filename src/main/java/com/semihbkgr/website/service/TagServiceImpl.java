package com.semihbkgr.website.service;

import com.semihbkgr.website.model.Tag;
import com.semihbkgr.website.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public Flux<Tag> findAllBySubjectId(int subjectId) {
        return tagRepository.findAllBySubjectIdOrderByDisplayOrderAsc(subjectId);
    }

}
