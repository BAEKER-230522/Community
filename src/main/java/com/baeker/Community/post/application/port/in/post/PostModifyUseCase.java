package com.baeker.Community.post.application.port.in.post;

import com.baeker.Community.post.domain.Post;

public interface PostModifyUseCase {

    void follow(Long memberId, Post post);

    void post();
}
