package com.baeker.Community.post.application.service.post;

import com.baeker.Community.global.exception.service.NoPermissionException;
import com.baeker.Community.post.application.service.repositoryMock.PostMock;
import com.baeker.Community.post.domain.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.baeker.Community.global.testUtil.CreateObject.createPost;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("단위 - 게시물 삭제")
@ExtendWith(MockitoExtension.class)
class PostDeleteService_postTest extends PostMock {

    @InjectMocks
    PostDeleteService deleteService;

    @BeforeEach
    void setup() {
        savePostMocking();
        deletePostMocking();
    }


    @Test
    @DisplayName("게시물 삭제 성공")
    void no1() {
        Long
                memberId = 1L,
                postId = 1L;
        Post post = createPost(memberId, postId);


        deleteService.post(memberId, post);
    }

    @Test
    @DisplayName("권한이 없을 경우")
    void no2() {
        Long
                memberId = 1L,
                postId = 1L;
        Post post = createPost(memberId, postId);


        assertThatThrownBy(() -> deleteService.post(2L, post))
                .isInstanceOf(NoPermissionException.class)
                .hasMessageContaining("권한이 없습니다.");
    }
}