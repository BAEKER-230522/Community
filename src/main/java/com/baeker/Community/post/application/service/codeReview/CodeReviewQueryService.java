package com.baeker.Community.post.application.service.codeReview;

import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.post.application.port.in.codeReview.CodeReviewQueryUseCase;
import com.baeker.Community.post.application.port.out.CodeReviewRepositoryPort;
import com.baeker.Community.post.domain.CodeReview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CodeReviewQueryService implements CodeReviewQueryUseCase {

    private final CodeReviewRepositoryPort repository;


    @Override
    public CodeReview byProblemStatusId(Long problemStatusId) {
        Optional<CodeReview> byProblemStatusId = repository.findByProblemStatusId(problemStatusId);

        if (byProblemStatusId.isPresent())
            return byProblemStatusId.get();

        throw new NotFoundException("존재하지 않는 게시물");
    }
}
