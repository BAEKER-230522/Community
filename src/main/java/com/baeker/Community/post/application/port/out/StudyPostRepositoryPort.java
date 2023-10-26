package com.baeker.Community.post.application.port.out;

import com.baeker.Community.post.domain.StudyPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyPostRepositoryPort extends JpaRepository<StudyPost, Long> {

    List<StudyPost> findByStudyId(Long studyId);
}
