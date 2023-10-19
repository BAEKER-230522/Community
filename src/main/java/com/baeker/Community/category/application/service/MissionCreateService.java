package com.baeker.Community.category.application.service;

import com.baeker.Community.global.dto.reqDto.SettingChallengerDto;
import com.baeker.Community.global.dto.reqDto.SettingMissionDto;
import com.baeker.Community.category.application.prot.in.MissionCreateUseCase;
import com.baeker.Community.category.application.prot.out.MissionRepositoryPort;
import com.baeker.Community.category.domain.Mission;
import com.baeker.Community.post.application.port.in.PostCreateUseCase;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionCreateService implements MissionCreateUseCase {

    private final MissionRepositoryPort repository;
    private final PostCreateUseCase postCreateUseCase;

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
        List<Post> codeReviewList = challenger.getCodeReviewList();

        for (Long problemStatusId : dto.getProblemStatusId())
            codeReviewList.add(
                    postCreateUseCase.setting(problemStatusId)
            );

        return challenger;
    }
}
