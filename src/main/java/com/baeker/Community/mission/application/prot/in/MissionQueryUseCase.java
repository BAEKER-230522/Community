package com.baeker.Community.mission.application.prot.in;

import com.baeker.Community.mission.domain.Mission;
import com.baeker.Community.post.domain.category.CodeReview;

public interface MissionQueryUseCase {

    Mission byMissionId(Long missionId);
}
