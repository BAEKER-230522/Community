package com.baeker.Community.comment.application.port.in.comment;

import com.baeker.Community.post.domain.Post;

public interface CommentCreateUseCase {

    void write(Long memberId, String content, Post post);
}
