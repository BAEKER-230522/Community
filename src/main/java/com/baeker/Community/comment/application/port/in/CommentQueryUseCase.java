package com.baeker.Community.comment.application.port.in;

import com.baeker.Community.global.dto.resDto.CommentDto;
import com.baeker.Community.post.domain.Post;

import java.util.List;

public interface CommentQueryUseCase {

    List<CommentDto> byPost(Post post);
}
