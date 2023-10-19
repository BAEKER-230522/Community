package com.baeker.Community.post.application.port.in;

import com.baeker.Community.post.domain.Post;

public interface PostCreateUseCase {

    Post setting(Long problemStatusId);
}
