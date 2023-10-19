package com.baeker.Community.post.application.port.in;

import com.baeker.Community.post.domain.post.Post;

public interface PostCreateUseCase {

    Post setting(Long problemStatusId);
}
