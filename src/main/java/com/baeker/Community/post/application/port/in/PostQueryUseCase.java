package com.baeker.Community.post.application.port.in;

import com.baeker.Community.post.domain.post.Post;

public interface PostQueryUseCase {

    Post byId(String postId);

    Post byPersonalId(Long personalId);
}
