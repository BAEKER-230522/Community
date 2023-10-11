package com.baeker.Community.comment.application.port.out;

import com.baeker.Community.comment.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepositoryPort extends MongoRepository<Comment, String> {
}
