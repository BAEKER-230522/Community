package com.baeker.Community.category.application.prot.in.mission;

import com.baeker.Community.global.dto.reqDto.SettingMissionDto;
import com.baeker.Community.category.domain.Mission;

public interface MissionCreateUseCase {

    void setting(SettingMissionDto dto);
}
