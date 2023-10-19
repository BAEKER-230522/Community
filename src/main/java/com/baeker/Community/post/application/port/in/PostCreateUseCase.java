package com.baeker.Community.post.application.port.in;

import com.baeker.Community.category.domain.CodeReview;
import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.post.domain.Post;

public interface PostCreateUseCase {
    CodeReviewDto write(Long memberId, CreateCodeReviewDto dto, CodeReview codeReview);
}
