package com.baeker.Community.post.application.port.in.post;

import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.post.domain.Post;

import java.util.List;

public interface PostQueryUseCase {

    Post byId(Long postId);
}
