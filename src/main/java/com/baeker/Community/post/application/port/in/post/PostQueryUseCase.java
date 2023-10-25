package com.baeker.Community.post.application.port.in.post;

import com.baeker.Community.post.domain.Post;

public interface PostQueryUseCase {

    Post byId(Long postId);
}
