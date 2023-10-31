package com.baeker.Community.post.application.service.post;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.reqDto.CreateStudyPostDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.dto.resDto.StudyPostDto;
import com.baeker.Community.global.exception.service.InvalidDuplicateException;
import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.post.application.port.in.codeReview.CodeReviewQueryUseCase;
import com.baeker.Community.post.application.port.in.post.PostCreateUseCase;
import com.baeker.Community.post.application.port.out.feign.StudyClientPort;
import com.baeker.Community.post.application.port.out.persistence.PostRepositoryPort;
import com.baeker.Community.post.domain.CodeReview;
import com.baeker.Community.post.domain.StudyPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostCreateService implements PostCreateUseCase {

    private final PostRepositoryPort repository;
    private final StudyClientPort studyClientPort;
    private final CodeReviewQueryUseCase codeReviewQueryUseCase;

    @Override
    public CodeReviewDto codeReview(Long memberId, CreateCodeReviewDto dto) {
        isNew(dto.getProblemStatusId());
        isMember(memberId, dto.getStudyId());

        CodeReview codeReview = repository.save(
                CodeReview.write(memberId, dto)
        );
        return new CodeReviewDto(codeReview);
    }

    @Override
    public StudyPostDto studyPost(Long memberId, CreateStudyPostDto dto) {
        isMember(memberId, dto.getStudyId());

        StudyPost studyPost = repository.save(
                StudyPost.write(memberId, dto)
        );
        return new StudyPostDto(studyPost);
    }



    private void isNew(Long problemStatusId) {
        try {
            codeReviewQueryUseCase.byProblemStatusId(problemStatusId);
            throw new InvalidDuplicateException("이미 등록된 게시물");
        } catch (NotFoundException e) {}
    }

    private void isMember(Long memberId, Long studyId) {
        studyClientPort.isMember(memberId, studyId);
    }
}
