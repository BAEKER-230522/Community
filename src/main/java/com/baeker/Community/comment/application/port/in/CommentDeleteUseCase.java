package com.baeker.Community.comment.application.port.in;

import com.baeker.Community.comment.domain.Comment;

public interface CommentDeleteUseCase {

    void comment(Long memberId, Comment comment);
}
