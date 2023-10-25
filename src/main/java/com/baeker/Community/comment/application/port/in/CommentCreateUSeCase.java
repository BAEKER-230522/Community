package com.baeker.Community.comment.application.port.in;

import com.baeker.Community.global.dto.reqDto.CreateCommentDto;
import com.baeker.Community.global.dto.resDto.CommentDto;
import com.baeker.Community.post.domain.Post;

public interface CommentCreateUSeCase {

    CommentDto write(Long memberId, Post post, CreateCommentDto dto);
}
