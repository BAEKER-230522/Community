package com.baeker.Community.category.application.prot.in.codeReview;

import com.baeker.Community.category.domain.Mission;
import com.baeker.Community.global.dto.reqDto.SettingChallengerDto;

import java.util.List;

public interface CodeReviewCreateUseCase {

    void setting(Mission mission, List<SettingChallengerDto> challengerList);
}
