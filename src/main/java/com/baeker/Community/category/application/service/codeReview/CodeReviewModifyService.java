package com.baeker.Community.category.application.service.codeReview;

import com.baeker.Community.category.application.prot.in.codeReview.CodeReviewModifyUseCase;
import com.baeker.Community.category.application.prot.out.CodeReviewRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CodeReviewModifyService implements CodeReviewModifyUseCase {

    private final CodeReviewRepositoryPort repository;
}
