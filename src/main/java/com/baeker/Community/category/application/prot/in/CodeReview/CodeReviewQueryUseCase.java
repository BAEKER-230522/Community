package com.baeker.Community.category.application.prot.in.CodeReview;

import com.baeker.Community.category.domain.CodeReview;
import com.baeker.Community.global.dto.resDto.ChallengerDto;

import java.util.List;

public interface CodeReviewQueryUseCase {

    List<ChallengerDto> byMissionId(Long missionId);

    CodeReview byProblemStatusId(Long problemStatusId);
}
