package com.baeker.Community.category.application.prot.in;

import com.baeker.Community.category.domain.Mission;

public interface MissionQueryUseCase {

    Mission byMissionId(Long missionId);
}
