package com.baeker.Community.category.application.service.codeReview;

import com.baeker.Community.category.application.prot.in.codeReview.CodeReviewModifyUseCase;
import com.baeker.Community.category.application.prot.out.CodeReviewRepositoryPort;
import com.baeker.Community.category.domain.CodeReview;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeReviewModifyService implements CodeReviewModifyUseCase {

    private final CodeReviewRepositoryPort repository;

    @Override
    public void write(CodeReview codeReview, Post post) {
        repository.save(
                codeReview.write(post)
        );
    }
}
