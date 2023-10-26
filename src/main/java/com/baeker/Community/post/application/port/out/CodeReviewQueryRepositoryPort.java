package com.baeker.Community.post.application.port.out;

import com.baeker.Community.global.dto.resDto.CodeReviewDto;

import java.util.List;

public interface CodeReviewQueryRepositoryPort {

    List<CodeReviewDto> byMissionAndMemberId(Long missionId, Long memberId);
}
