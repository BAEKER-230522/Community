package com.baeker.Community.post.application.service;

import com.baeker.Community.post.application.port.in.PostModifyUseCase;
import com.baeker.Community.post.application.port.out.PostRepositoryPort;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostModifyService implements PostModifyUseCase {

    private final PostRepositoryPort repository;

    @Override
    public void follow(Long memberId, Post post) {
        post.follow(memberId);
        repository.save(post);
    }
}