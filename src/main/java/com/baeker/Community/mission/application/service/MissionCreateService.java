package com.baeker.Community.mission.application.service;

import com.baeker.Community.global.dto.reqDto.CreatePostsReqDto;
import com.baeker.Community.mission.application.prot.in.MissionCreateUseCase;
import com.baeker.Community.mission.application.prot.out.MissionRepositoryPort;
import com.baeker.Community.mission.domain.Mission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCreateService implements MissionCreateUseCase {

    private final MissionRepositoryPort repository;

    @Override
    public Mission setting(CreatePostsReqDto dto) {
        return repository.save(
                Mission.setting(dto)
        );
    }
}
