package com.baeker.Community.comment.application.port.in;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.dto.resDto.CommentDto;

public interface CommentModifyUseCase {

    CommentDto content(Long memberId, Comment comment, String content);
}
