package com.baeker.Community.post.application.port.in.post;

import com.baeker.Community.global.dto.resDto.PostResDto;
import com.baeker.Community.post.domain.Post;

public interface PostQueryUseCase {

    Post byId(String postId);

    PostResDto byPersonalId(Long personalId);
}
