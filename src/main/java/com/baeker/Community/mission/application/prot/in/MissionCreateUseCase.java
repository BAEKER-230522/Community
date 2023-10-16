package com.baeker.Community.mission.application.prot.in;

import com.baeker.Community.global.dto.reqDto.CreatePostsReqDto;
import com.baeker.Community.mission.domain.Mission;

public interface MissionCreateUseCase {

    Mission setting(CreatePostsReqDto dto);
}
