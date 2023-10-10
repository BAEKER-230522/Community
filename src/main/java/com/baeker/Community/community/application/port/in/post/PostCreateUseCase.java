package com.baeker.Community.community.application.port.in.post;

import com.baeker.Community.global.dto.reqDto.CreatePostDto;
import com.baeker.Community.global.dto.resDto.PostResDto;

public interface PostCreateUseCase {

    PostResDto post(Long memberId, CreatePostDto dto);
}
