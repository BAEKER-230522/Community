package com.baeker.Community.post.application.port.in;

import com.baeker.Community.global.dto.reqDto.CreatePostDto;
import com.baeker.Community.global.dto.resDto.CodeReviewResDto;
import com.baeker.Community.mission.domain.Mission;

public interface PostCreateUseCase {

    CodeReviewResDto mission(Long memberId, CreatePostDto dto, Mission mission);
}
