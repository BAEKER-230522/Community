package com.baeker.Community.post.application.service;

import com.baeker.Community.category.application.prot.in.CodeReview.CodeReviewModifyUseCase;
import com.baeker.Community.category.domain.CodeReview;
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

    private final CodeReviewModifyUseCase codeReviewModifyUseCase;
    private final PostRepositoryPort repository;

    @Override
    public CodeReviewDto write(Long memberId, CreateCodeReviewDto dto, CodeReview codeReview) {
        Post post = repository.save(
                Post.write(memberId, dto)
        );
        codeReviewModifyUseCase.write(codeReview, post);
        return new CodeReviewDto(post, codeReview.getProblemStatusId());
    }
}
