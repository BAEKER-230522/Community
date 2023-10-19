package com.baeker.Community.mission.application.prot.in;

import com.baeker.Community.mission.domain.Mission;

public interface MissionQueryUseCase {

    Mission byMissionId(Long missionId);
}
