package com.baeker.Community.post.application.port.out.persistence;

import com.baeker.Community.post.domain.CodeReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CodeReviewRepositoryPort extends JpaRepository<CodeReview, Long> {
    Optional<CodeReview> findByProblemStatusId(Long problemStatusId);

    List<CodeReview> findByMissionIdAndMemberId(Long missionId, Long memberId);
}
