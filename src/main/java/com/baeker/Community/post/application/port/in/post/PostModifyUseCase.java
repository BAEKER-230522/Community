package com.baeker.Community.post.application.port.in.post;

import com.baeker.Community.global.dto.reqDto.ModifyPostDto;
import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.post.domain.Post;

public interface PostModifyUseCase {

    void follow(Long memberId, Post post);

    PostDto post(Long memberId, Post post, ModifyPostDto dto);

    void addPageView(Post post);
}
