package com.baeker.Community.comment.application.port.out;

import com.baeker.Community.global.dto.resDto.CommentDto;
import com.baeker.Community.post.domain.Post;

import java.util.List;

public interface CommentQueryRepositoryPort {

    List<CommentDto> byPost(Post post);
}
