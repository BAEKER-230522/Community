package com.baeker.Community.post.application.service.repositoryMock;

import com.baeker.Community.post.application.port.out.persistence.PostRepositoryPort;
import com.baeker.Community.post.domain.Post;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class PostMock extends StudyClientMock{

    private PostRepositoryPort repository =
            Mockito.mock(PostRepositoryPort.class);


    public void savePostMocking() {
        when(repository.save(any()))
                .thenAnswer(invocation -> {
                    Post post = (Post) invocation.getArgument(0);
                    return post;
                });
    }

    public void deletePostMocking() {
        doNothing().when(repository)
                .delete(any());
    }
}
