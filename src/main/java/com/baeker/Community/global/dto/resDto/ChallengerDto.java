package com.baeker.Community.global.dto.resDto;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ChallengerDto {

    private Long memberId;
    private List<CodeReviewDto> codeReviewList;

    public ChallengerDto(Challenger challenger) {
        this.memberId = challenger.getMemberId();
        this.codeReviewList = challenger
                .getCodeReviewList().stream()
                .map(CodeReviewDto::new)
                .collect(Collectors.toList());
    }
}