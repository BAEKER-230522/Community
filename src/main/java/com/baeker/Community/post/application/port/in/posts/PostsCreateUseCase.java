package com.baeker.Community.post.application.port.in.posts;

import com.baeker.Community.global.dto.reqDto.CreatePostsReqDto;
import com.baeker.Community.post.domain.posts.Posts;

public interface PostsCreateUseCase {

    Posts setting(CreatePostsReqDto dto);
}
