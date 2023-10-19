package com.baeker.Community.category.application.service;

import com.baeker.Community.category.application.prot.in.CodeReview.CodeReviewCreateUseCase;
import com.baeker.Community.category.application.prot.out.CodeReviewRepositoryPort;
import com.baeker.Community.category.domain.CodeReview;
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
    public void setting(SettingMissionDto dto) {
        for (SettingChallengerDto challengers : dto.getMemberList())
            challengeSetting(
                    challengers.getMemberId(),
                    challengers.getProblemStatusIdList()
            );
    }

    private void challengeSetting(Long memberId, List<Long> problemStatusIdList) {
        for (Long problemStatusId : problemStatusIdList)
            repository.save(
                    CodeReview.setting(memberId, problemStatusId)
            );
    }
}
