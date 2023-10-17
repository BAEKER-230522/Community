package com.baeker.Community.post.application.port.out;

import com.baeker.Community.post.domain.category.CodeReview;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CodeReviewRepositoryPort extends MongoRepository<CodeReview, String> {

    Optional<CodeReview> findByProblemStatusId(Long problemStatusId);
}
