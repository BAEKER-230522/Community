package com.baeker.Community.post.application.port.in.post;

import com.baeker.Community.post.domain.Post;

public interface PostDeleteUseCase {

    void post(Long memberId, Post post);
}
