package com.baeker.Community.category.application.prot.in.mission;

import com.baeker.Community.category.domain.Mission;
import com.baeker.Community.global.dto.resDto.ChallengerDto;

import java.util.List;

public interface MissionQueryUseCase {

    Mission byMissionId(Long missionId);
}