package com.baeker.Community.post.application.port.in.codeReview;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.post.domain.category.CodeReview;

public interface CodeReviewCreateUseCase {

    CodeReview setting(Long problemStatusId);

    CodeReviewDto write(Long memberId, CreateCodeReviewDto dto, CodeReview codeReview);
}
