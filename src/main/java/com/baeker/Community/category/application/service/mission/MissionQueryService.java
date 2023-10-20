package com.baeker.Community.category.application.service.mission;

import com.baeker.Community.category.application.prot.in.mission.MissionQueryUseCase;
import com.baeker.Community.category.application.prot.out.MissionRepositoryPort;
import com.baeker.Community.global.dto.resDto.ChallengerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MissionQueryService implements MissionQueryUseCase {

    private final MissionRepositoryPort repository;

    @Override
    public List<ChallengerDto> byMissionId(Long missionId) {
        return null;
    }
}
