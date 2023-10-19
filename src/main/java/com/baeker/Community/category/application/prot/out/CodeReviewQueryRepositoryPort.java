package com.baeker.Community.category.application.prot.out;

import com.baeker.Community.global.dto.resDto.ChallengerDto;

import java.util.List;

public interface CodeReviewQueryRepositoryPort {

    List<ChallengerDto> findByMissionId(Long missionId);
}
