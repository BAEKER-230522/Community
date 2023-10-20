package com.baeker.Community.post.application.port.in;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;

public interface PostCreateUseCase {

    CodeReviewDto write(Long memberId, CreateCodeReviewDto dto);
}
