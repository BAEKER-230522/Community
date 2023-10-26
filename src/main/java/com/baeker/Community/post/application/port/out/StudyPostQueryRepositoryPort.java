package com.baeker.Community.post.application.port.out;

import com.baeker.Community.global.dto.resDto.StudyPostDto;

import java.util.List;

public interface StudyPostQueryRepositoryPort {

    List<StudyPostDto> byStudyId(Long studyId);
}
