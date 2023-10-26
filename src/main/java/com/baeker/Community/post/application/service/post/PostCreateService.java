package com.baeker.Community.post.application.service.post;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.reqDto.CreateStudyPostDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.dto.resDto.StudyPostDto;
import com.baeker.Community.post.application.port.in.post.PostCreateUseCase;
import com.baeker.Community.post.application.port.out.PostRepositoryPort;
import com.baeker.Community.post.domain.CodeReview;
import com.baeker.Community.post.domain.Post;
import com.baeker.Community.post.domain.StudyPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostCreateService implements PostCreateUseCase {

    private final PostRepositoryPort repository;

    @Override
    public CodeReviewDto codeReview(Long memberId, CreateCodeReviewDto dto) {

        // study 회원인지 확인

        CodeReview codeReview = repository.save(
                CodeReview.write(memberId, dto)
        );
        return new CodeReviewDto(codeReview);
    }

    @Override
    public StudyPostDto studyPost(Long memberId, CreateStudyPostDto dto) {

        // study 회원인지 확인

        StudyPost studyPost = repository.save(
                StudyPost.write(memberId, dto)
        );
        return new StudyPostDto(studyPost);
    }
}
