package com.baeker.Community.post.application.port.out.persistence;

import com.baeker.Community.post.domain.CodeReview;
import com.baeker.Community.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepositoryPort extends JpaRepository<Post, Long> {
}
