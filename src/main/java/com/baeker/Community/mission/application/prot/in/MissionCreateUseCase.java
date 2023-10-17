package com.baeker.Community.mission.application.prot.in;

import com.baeker.Community.global.dto.reqDto.SettingMissionDto;
import com.baeker.Community.mission.domain.Mission;

public interface MissionCreateUseCase {

    Mission setting(SettingMissionDto dto);
}
