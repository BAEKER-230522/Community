package com.baeker.Community.mission.application.prot.out;

import com.baeker.Community.mission.domain.Mission;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MissionRepositoryPort extends MongoRepository<Mission, String> {

    Optional<Mission> findByMissionId(Long missionId);
}
