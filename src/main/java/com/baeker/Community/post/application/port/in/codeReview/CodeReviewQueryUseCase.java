package com.baeker.Community.post.application.port.in.codeReview;

import com.baeker.Community.post.domain.CodeReview;

public interface CodeReviewQueryUseCase {

    CodeReview byProblemStatusId(Long problemStatusId);

}
