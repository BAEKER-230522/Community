package com.baeker.Community.post.adapter.out;

import com.baeker.Community.global.dto.resDto.StudyPostDto;
import com.baeker.Community.post.application.port.out.StudyPostQueryRepositoryPort;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudyPostQueryRepositoryAdapter implements StudyPostQueryRepositoryPort {

    private final JPAQueryFactory query;

    @Override
    public List<StudyPostDto> byStudyId(Long studyId) {
        return null;
    }
}
