package com.baeker.Community.category.application.service.codeReview;

import com.baeker.Community.category.application.prot.in.codeReview.CodeReviewCreateUseCase;
import com.baeker.Community.category.application.prot.out.CodeReviewRepositoryPort;
import com.baeker.Community.category.domain.CodeReview;
import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CodeReviewCreateService implements CodeReviewCreateUseCase {

    private final CodeReviewRepositoryPort repository;

    @Override
    public void write(Post post, CreateCodeReviewDto dto) {
        repository.save(
                CodeReview.write(post, dto)
        );
    }
}
