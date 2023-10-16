package com.baeker.Community.mission.application.service;

import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.mission.application.prot.in.MissionQueryUseCase;
import com.baeker.Community.mission.application.prot.out.MissionRepositoryPort;
import com.baeker.Community.mission.domain.Mission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionQueryService implements MissionQueryUseCase {

    private final MissionRepositoryPort repository;

    @Override
    public Mission byMissionId(Long missionId) {
        Optional<Mission> byMissionId = repository.findByMissionId(missionId);

        if (byMissionId.isPresent())
            return byMissionId.get();

        throw new NotFoundException("존재하지 않는 미션");
    }
}