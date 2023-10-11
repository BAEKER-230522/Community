package com.baeker.Community.post.application.service.posts;

import com.baeker.Community.global.dto.reqDto.CreatePostsReqDto;
import com.baeker.Community.post.application.port.in.posts.PostsCreateUseCase;
import com.baeker.Community.post.application.port.out.PostsRepositoryPort;
import com.baeker.Community.post.domain.posts.Posts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostsCreateService implements PostsCreateUseCase {

    private final PostsRepositoryPort repository;


    @Override
    public Posts setting(CreatePostsReqDto dto) {
        return repository.save(
                Posts.create(dto)
        );
    }
}
