package com.baeker.Community.category.application.prot.out;

import com.baeker.Community.category.domain.Mission;
import com.baeker.Community.global.dto.resDto.ChallengerDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;

import java.util.List;

public interface CodeReviewQueryRepositoryPort {

    List<CodeReviewDto> problemStatusId(Long problemStatusId);

    List<ChallengerDto> byMission(Mission mission);
}
