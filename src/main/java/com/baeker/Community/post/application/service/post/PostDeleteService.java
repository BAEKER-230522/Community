package com.baeker.Community.post.application.service.post;

import com.baeker.Community.post.application.port.in.post.PostDeleteUseCase;
import com.baeker.Community.post.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostDeleteService implements PostDeleteUseCase {

    private final MongoTemplate repository;

    @Override
    public void post(Post post) {

    }
}
