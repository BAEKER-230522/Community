package com.baeker.Community.global.dto.resDto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.List;

@Data
public class ChallengerDto {

    private Long memberId;
    private List<CodeReviewDto> codeReviewList;

    @QueryProjection
    public ChallengerDto(Long memberId, List<CodeReviewDto> codeReviewList) {
        this.memberId = memberId;
        this.codeReviewList = codeReviewList;
    }
}
