package com.baeker.Community.category.application.prot.out;

import com.baeker.Community.category.domain.CodeReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodeReviewRepositoryPort extends JpaRepository<CodeReview, Long> {

    Optional<CodeReview> findByProblemStatusId(Long problemStatusId);
}
