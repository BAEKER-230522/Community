package com.baeker.Community.post.application.port.in;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.post.domain.Post;

public interface PostModifyUseCase {

    void follow(Long memberId, Post post);
}
