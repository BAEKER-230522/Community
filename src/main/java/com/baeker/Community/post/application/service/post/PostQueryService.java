package com.baeker.Community.post.application.service.post;

import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostQueryService implements PostQueryUseCase {

    private final MongoTemplate mongoTemplate;

    @Override
    public void byId(String postId) {
//        mongoTemplate.find()
    }
}
