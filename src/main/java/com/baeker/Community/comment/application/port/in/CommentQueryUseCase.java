package com.baeker.Community.comment.application.port.in;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.dto.resDto.CommentDto;
import com.baeker.Community.post.domain.Post;

import java.util.List;

public interface CommentQueryUseCase {

    Comment byId(Long commentId);
    List<CommentDto> byPost(Post post);
}
