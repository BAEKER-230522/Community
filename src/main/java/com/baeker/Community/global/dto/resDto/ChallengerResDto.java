package com.baeker.Community.global.dto.resDto;

import lombok.Data;

import java.util.List;

@Data
public class ChallengerResDto {

    private Long memberId;
    private List<CodeReviewDto> codeReviewList;

    public ChallengerResDto(Long memberId, List<CodeReviewDto> dtos) {
        this.memberId = memberId;
        this.codeReviewList = dtos;
    }
}
