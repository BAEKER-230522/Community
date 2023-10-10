package com.baeker.Community.community.application.service.post;

import com.baeker.Community.community.application.port.in.post.PostDeleteUseCase;
import com.baeker.Community.community.application.port.out.PostRepositoryPort;
import com.baeker.Community.community.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostDeleteService implements PostDeleteUseCase {

    private final PostRepositoryPort repository;

    @Override
    public void post(Post post) {

    }
}
