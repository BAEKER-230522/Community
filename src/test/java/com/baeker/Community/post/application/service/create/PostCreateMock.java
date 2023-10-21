package com.baeker.Community.post.application.service.create;

import com.baeker.Community.category.application.prot.in.codeReview.CodeReviewCreateUseCase;
import com.baeker.Community.post.application.service.postUtil.PostMock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

public class PostCreateMock  extends PostMock {

    private CodeReviewCreateUseCase codeReviewCreateUseCase =
            Mockito.mock(CodeReviewCreateUseCase.class);


    public void writeCodeReviewMocking() {
        doNothing()
                .when(codeReviewCreateUseCase)
                .write(any(), any());
    }
}
