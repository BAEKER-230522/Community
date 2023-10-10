package com.baeker.Community.community.application.port.out;

import com.baeker.Community.community.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepositoryPort extends MongoRepository<Post, String> {
}
