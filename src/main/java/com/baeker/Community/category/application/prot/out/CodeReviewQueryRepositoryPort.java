package com.baeker.Community.category.application.prot.out;

import com.baeker.Community.global.dto.resDto.CodeReviewDto;

import java.util.List;

public interface CodeReviewQueryRepositoryPort {

    List<CodeReviewDto> problemStatusId(Long problemStatusId);

    List<CodeReviewDto> findCodeReviewDtoList(Long missionId, Long memberId);
}
