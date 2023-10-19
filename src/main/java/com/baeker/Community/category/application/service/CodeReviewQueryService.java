package com.baeker.Community.category.application.service;

import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.category.application.prot.in.CodeReview.CodeReviewQueryUseCase;
import com.baeker.Community.category.application.prot.out.CodeReviewRepositoryPort;
import com.baeker.Community.category.domain.CodeReview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CodeReviewQueryService implements CodeReviewQueryUseCase {

    private final CodeReviewRepositoryPort repository;

    @Override
    public CodeReview byMissionId(Long missionId) {
        Optional<CodeReview> byMissionId = repository.findByMissionId(missionId);

        if (byMissionId.isPresent())
            return byMissionId.get();

        throw new NotFoundException("존재하지 않는 미션");
    }

    @Override
    public CodeReview byProblemStatusId(Long problemStatusId) {
        Optional<CodeReview> byProblemStatusId = repository.findByProblemStatusId(problemStatusId);

        if (byProblemStatusId.isPresent())
            return byProblemStatusId.get();

        throw new NotFoundException("존재하지 않는 게시물");
    }
}
