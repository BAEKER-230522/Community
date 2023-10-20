package com.baeker.Community.category.application.prot.in.codeReview;

import com.baeker.Community.category.domain.CodeReview;
import com.baeker.Community.category.domain.Mission;
import com.baeker.Community.global.dto.resDto.ChallengerDto;

import java.util.List;

public interface CodeReviewQueryUseCase {

    CodeReview byProblemStatusId(Long problemStatusId);
    List<ChallengerDto> byMission(Mission mission);
}
