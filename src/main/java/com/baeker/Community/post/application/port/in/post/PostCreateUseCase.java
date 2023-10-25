package com.baeker.Community.post.application.port.in.post;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;

public interface PostCreateUseCase {

    CodeReviewDto codeReview(Long memberId, CreateCodeReviewDto dto);
}
