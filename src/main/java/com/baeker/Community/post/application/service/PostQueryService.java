package com.baeker.Community.post.application.service;

import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.post.application.port.in.PostQueryUseCase;
import com.baeker.Community.post.application.port.out.PostRepositoryPort;
import com.baeker.Community.post.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostQueryService implements PostQueryUseCase {

    private final PostRepositoryPort repository;


    @Override
    public Post byId(String postId) {
        Optional<Post> byId = repository.findById(postId);

        if (!byId.isPresent())
            throw new NotFoundException("존재하지 않는 게시물");

        return byId.get();
    }

    @Override
    public Post byPersonalId(Long personalId) {
        Optional<Post> byPersonalId = repository.findByPersonalId(personalId);

        if (!byPersonalId.isPresent())
            throw new NotFoundException("존재하지 않는 게시물");

        return byPersonalId.get();
    }
}
