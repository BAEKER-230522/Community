package com.baeker.Community.post.application.service.post;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.post.application.port.in.post.PostCreateUseCase;
import com.baeker.Community.post.application.port.out.PostRepositoryPort;
import com.baeker.Community.post.domain.CodeReview;
import com.baeker.Community.post.domain.Post;
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
        CodeReview codeReview = CodeReview.write(memberId, dto);
        Post post = repository.save(codeReview);
        return new CodeReviewDto(post.getId(), codeReview);
    }
}
