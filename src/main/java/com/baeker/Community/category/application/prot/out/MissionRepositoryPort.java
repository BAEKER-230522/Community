package com.baeker.Community.category.application.prot.out;

import com.baeker.Community.category.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MissionRepositoryPort extends JpaRepository<Mission, Long> {

    Optional<Mission> findByMissionId(Long missionId);
}
