package com.baeker.Community.post.application.port.out;

import com.baeker.Community.post.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PostRepositoryPort extends MongoRepository<Post, String> {

    Optional<Post> findByPersonalId(Long personalId);
}
