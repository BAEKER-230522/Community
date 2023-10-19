package com.baeker.Community.category.application.prot.in.CodeReview;

import com.baeker.Community.category.domain.CodeReview;

public interface CodeReviewQueryUseCase {

    CodeReview byMissionId(Long missionId);
}
