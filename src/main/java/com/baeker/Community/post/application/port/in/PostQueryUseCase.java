package com.baeker.Community.post.application.port.in;

import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.post.domain.Post;

import java.util.List;

public interface PostQueryUseCase {

    Post byId(String postId);

    List<PostDto> byMemberId(Long memberId);
}
