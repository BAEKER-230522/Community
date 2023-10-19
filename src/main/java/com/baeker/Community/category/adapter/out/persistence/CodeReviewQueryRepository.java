package com.baeker.Community.category.adapter.out.persistence;

import com.baeker.Community.category.application.prot.out.CodeReviewQueryRepositoryPort;
import com.baeker.Community.global.dto.resDto.ChallengerDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CodeReviewQueryRepository implements CodeReviewQueryRepositoryPort {

    private final JPAQueryFactory query;

    @Override
    public List<ChallengerDto> findByMissionId(Long missionId) {
        return null;
    }
}
