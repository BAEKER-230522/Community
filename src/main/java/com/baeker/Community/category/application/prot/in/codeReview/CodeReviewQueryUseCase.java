package com.baeker.Community.category.application.prot.in.codeReview;

import com.baeker.Community.category.domain.CodeReview;

public interface CodeReviewQueryUseCase {

    CodeReview byProblemStatusId(Long problemStatusId);
}
