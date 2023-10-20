package com.baeker.Community.category.application.service.codeReview;

import com.baeker.Community.category.application.prot.in.codeReview.CodeReviewCreateUseCase;
import com.baeker.Community.category.application.prot.out.CodeReviewRepositoryPort;
import com.baeker.Community.category.domain.CodeReview;
import com.baeker.Community.category.domain.Mission;
import com.baeker.Community.global.dto.reqDto.SettingChallengerDto;
import com.baeker.Community.global.dto.reqDto.SettingMissionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CodeReviewCreateService implements CodeReviewCreateUseCase {

    private final CodeReviewRepositoryPort repository;

    @Override
    public void setting(Mission mission, List<SettingChallengerDto> challengerList) {
        for (SettingChallengerDto challenger : challengerList)
            challengeSetting(
                    mission,
                    challenger.getProblemStatusIdList()
            );
    }

    private void challengeSetting(Mission mission, List<Long> problemStatusIdList) {
        for (Long problemStatusId : problemStatusIdList)
            repository.save(
                    CodeReview.setting(mission, problemStatusId)
            );
    }
}
