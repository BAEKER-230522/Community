package com.baeker.Community.category.application.service.codeReview.repositoryMock;

import com.baeker.Community.category.application.prot.out.CodeReviewRepositoryPort;
import com.baeker.Community.category.domain.CodeReview;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CodeReviewMock {

    private CodeReviewRepositoryPort repository =
            Mockito.mock(CodeReviewRepositoryPort.class);


    public void saveCodeReviewMocking() {
        when(repository.save(any()))
                .thenAnswer(invocation -> {
                    CodeReview codeReview = (CodeReview) invocation.getArgument(0);
                    return codeReview;
                });
    }
}
