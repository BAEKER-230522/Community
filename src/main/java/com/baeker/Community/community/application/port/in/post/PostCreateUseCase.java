package com.baeker.Community.community.application.port.in.post;

import com.baeker.Community.community.adapter.in.reqDto.CreatePostDto;
import com.baeker.Community.community.adapter.in.resDto.PostResDto;
import com.baeker.Community.community.domain.Post;

public interface PostCreateUseCase {

    PostResDto post(Long memberId, CreatePostDto dto);
}
