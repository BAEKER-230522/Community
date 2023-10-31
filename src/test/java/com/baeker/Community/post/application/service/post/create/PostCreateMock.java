package com.baeker.Community.post.application.service.post.create;

import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.post.application.port.in.codeReview.CodeReviewQueryUseCase;
import com.baeker.Community.post.application.service.repositoryMock.PostMock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class PostCreateMock extends PostMock {

    private CodeReviewQueryUseCase codeReviewQueryUseCase =
            Mockito.mock(CodeReviewQueryUseCase.class);


    public void newPostCheckMocking() {
        when(codeReviewQueryUseCase.byProblemStatusId(anyLong()))
                .thenAnswer(invocation -> {
                    Long problemStatusId = (Long) invocation.getArgument(0);

                    if (problemStatusId == 3L)
                        return null;

                    throw new NotFoundException("");
                });
    }
}
