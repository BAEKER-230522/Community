package com.baeker.Community.post.application.port.in;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.member.domain.Member;
import com.baeker.Community.post.domain.post.Post;

public interface PostModifyUseCase {

    CodeReviewDto write(Long memberId, CreateCodeReviewDto dto, Post post);

    void follow(Member member, Post post);
}
