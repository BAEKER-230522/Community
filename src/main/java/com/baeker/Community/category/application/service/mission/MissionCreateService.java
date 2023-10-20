package com.baeker.Community.category.application.service.mission;

import com.baeker.Community.category.application.prot.in.codeReview.CodeReviewCreateUseCase;
import com.baeker.Community.category.application.prot.in.mission.MissionCreateUseCase;
import com.baeker.Community.category.application.prot.out.MissionRepositoryPort;
import com.baeker.Community.category.domain.Mission;
import com.baeker.Community.global.dto.reqDto.SettingMissionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionCreateService implements MissionCreateUseCase {

    private final CodeReviewCreateUseCase codeReviewCreateUseCase;
    private final MissionRepositoryPort repository;


    @Override
    public void setting(SettingMissionDto dto) {
        Mission mission = repository.save(
                Mission.setting(dto.getMissionId())
        );
        codeReviewCreateUseCase.setting(mission, dto.getMemberList());
    }
}