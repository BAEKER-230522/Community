package com.baeker.Community.mission.application.service;

import com.baeker.Community.global.dto.reqDto.SettingChallengerDto;
import com.baeker.Community.global.dto.reqDto.SettingMissionDto;
import com.baeker.Community.mission.application.prot.in.MissionCreateUseCase;
import com.baeker.Community.mission.application.prot.out.MissionRepositoryPort;
import com.baeker.Community.mission.domain.Challenger;
import com.baeker.Community.mission.domain.Mission;
import com.baeker.Community.post.application.port.in.codeReview.CodeReviewCreateUseCase;
import com.baeker.Community.post.domain.category.CodeReview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionCreateService implements MissionCreateUseCase {

    private final MissionRepositoryPort repository;
    private final CodeReviewCreateUseCase codeReviewCreateUseCase;

    @Override
    public Mission setting(SettingMissionDto dto) {
        List<Challenger> challengers = new ArrayList<>();
        for (SettingChallengerDto memberDto : dto.getMemberList())
            challengers.add(settingCodeReview(memberDto));


        return repository.save(
                Mission.setting(dto, challengers)
        );
    }

    private Challenger settingCodeReview(SettingChallengerDto dto) {
        Challenger challenger = Challenger.create(dto.getMemberId());
        List<CodeReview> codeReviewList = challenger.getCodeReviewList();

        for (Long problemStatusId : dto.getProblemStatusId())
            codeReviewList.add(
                    codeReviewCreateUseCase.setting(problemStatusId)
            );

        return challenger;
    }
}
