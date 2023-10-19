package com.baeker.Community.category.application.service;

import com.baeker.Community.category.application.prot.in.MissionModifyUseCase;
import com.baeker.Community.category.application.prot.out.MissionRepositoryPort;
import com.baeker.Community.category.domain.Mission;
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
