package com.baeker.Community.comment.application.port.out;

import com.baeker.Community.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepositoryPort extends JpaRepository<Comment, Long> {
}
