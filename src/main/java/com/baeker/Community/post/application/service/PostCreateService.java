package com.baeker.Community.post.application.service;

import com.baeker.Community.category.application.prot.in.codeReview.CodeReviewCreateUseCase;
import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.post.application.port.in.PostCreateUseCase;
import com.baeker.Community.post.application.port.out.PostRepositoryPort;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostCreateService implements PostCreateUseCase {

    private final CodeReviewCreateUseCase codeReviewCreateUseCase;
    private final PostRepositoryPort repository;

    @Override
    public CodeReviewDto write(Long memberId, CreateCodeReviewDto dto) {
        Post post = repository.save(
                Post.write(memberId, dto)
        );
        codeReviewCreateUseCase.write(post, dto);
        return new CodeReviewDto(post, dto.getProblemStatusId());
    }
}
