package com.baeker.Community.mission.application.prot.out;

import com.baeker.Community.post.domain.category.CodeReview;

import java.util.Optional;

public interface MissionQueryRepositoryPort {

    Optional<CodeReview> byProblemStatusId(Long problemStatusId);
}
