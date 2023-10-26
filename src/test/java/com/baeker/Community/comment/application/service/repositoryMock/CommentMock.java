package com.baeker.Community.comment.application.service.repositoryMock;

import com.baeker.Community.comment.application.port.out.CommentRepositoryPort;
import com.baeker.Community.comment.domain.Comment;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class CommentMock {

    private CommentRepositoryPort repository =
            Mockito.mock(CommentRepositoryPort.class);


    public void saveCommentMocking() {
        when(repository.save(any()))
                .thenAnswer(invocation -> {
                    Comment comment = (Comment) invocation.getArgument(0);
                    return comment;
                });
    }

    public void deleteCommentMocking() {
        doNothing().when(repository).delete(any());
    }
}
