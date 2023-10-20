package com.baeker.Community.category.application.prot.out;

import com.baeker.Community.category.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepositoryPort extends JpaRepository<Mission, Long> {
}
