package com.baeker.Community.category.application.service;

import com.baeker.Community.category.application.prot.in.CodeReview.CodeReviewModifyUseCase;
import com.baeker.Community.category.application.prot.out.CodeReviewRepositoryPort;
import com.baeker.Community.category.domain.CodeReview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeReviewModifyService implements CodeReviewModifyUseCase {

    private final CodeReviewRepositoryPort repository;

    @Override
    public void write(CodeReview mission) {
        repository.save(mission);
    }
}
