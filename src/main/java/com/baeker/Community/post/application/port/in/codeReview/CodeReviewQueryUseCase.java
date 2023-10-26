package com.baeker.Community.post.application.port.in.codeReview;

import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.post.domain.CodeReview;

import java.util.List;

public interface CodeReviewQueryUseCase {

    CodeReview byId(Long postId);

    CodeReview byProblemStatusId(Long problemStatusId);
    List<CodeReviewDto> byMission(Long missionId, Long memberId);
}
