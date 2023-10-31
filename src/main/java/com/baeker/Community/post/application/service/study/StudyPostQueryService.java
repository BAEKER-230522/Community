package com.baeker.Community.post.application.service.study;

import com.baeker.Community.global.dto.resDto.StudyPostDto;
import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.post.application.port.in.study.StudyPostQueryUseCase;
import com.baeker.Community.post.application.port.out.persistence.StudyPostQueryRepositoryPort;
import com.baeker.Community.post.application.port.out.persistence.StudyPostRepositoryPort;
import com.baeker.Community.post.domain.StudyPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudyPostQueryService implements StudyPostQueryUseCase {

    private final StudyPostQueryRepositoryPort queryRepository;
    private final StudyPostRepositoryPort repository;


    @Override
    public List<StudyPostDto> byStudyId(Long studyId) {
        List<StudyPost> studyPostList = repository.findByStudyId(studyId);

        if (studyPostList.size()== 0)
            return new ArrayList<>();

        return studyPostList.stream()
                .map(StudyPostDto::new)
                .collect(Collectors.toList());
    }
}
