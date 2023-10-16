package com.baeker.Community.mission.application.service;

import com.baeker.Community.mission.application.prot.in.MissionModifyUseCase;
import com.baeker.Community.mission.application.prot.out.MissionRepositoryPort;
import com.baeker.Community.mission.domain.Mission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionModifyService implements MissionModifyUseCase {

    private final MissionRepositoryPort repository;

    @Override
    public void write(Mission mission) {
        repository.save(mission);
    }
}
