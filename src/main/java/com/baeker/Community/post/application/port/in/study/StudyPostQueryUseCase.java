package com.baeker.Community.post.application.port.in.study;

import com.baeker.Community.global.dto.resDto.StudyPostDto;

import java.util.List;

public interface StudyPostQueryUseCase {


    List<StudyPostDto> byStudyId(Long studyId);
}
