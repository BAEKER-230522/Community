package com.baeker.Community.category.application.service.mission;

import com.baeker.Community.category.application.prot.in.mission.MissionQueryUseCase;
import com.baeker.Community.category.application.prot.out.MissionRepositoryPort;
import com.baeker.Community.category.domain.Mission;
import com.baeker.Community.global.dto.resDto.ChallengerDto;
import com.baeker.Community.global.exception.service.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
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
