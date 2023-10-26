package com.baeker.Community.post.application.port.in.post;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.reqDto.CreateStudyPostDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.dto.resDto.StudyPostDto;

public interface PostCreateUseCase {

    CodeReviewDto codeReview(Long memberId, CreateCodeReviewDto dto);

    StudyPostDto studyPost(Long memberId, CreateStudyPostDto dto);
}
