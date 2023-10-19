package com.baeker.Community.mission.application.prot.out;

import java.util.Optional;

public interface MissionQueryRepositoryPort {

    Optional<CodeReview> byProblemStatusId(Long problemStatusId);
}
