package com.baeker.Community.category.application.prot.in.codeReview;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.post.domain.Post;

public interface CodeReviewCreateUseCase {

    void write(Post post, CreateCodeReviewDto dto);
}
