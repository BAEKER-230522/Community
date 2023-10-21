package com.baeker.Community.comment.application.service.comment.create;

import com.baeker.Community.comment.application.service.comment.CommentCreateService;
import com.baeker.Community.comment.application.service.comment.repository.CommentMock;
import com.baeker.Community.global.testUtil.CreateObject;
import com.baeker.Community.post.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.baeker.Community.global.testUtil.CreateObject.createPost;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게시물 댓글 작성 단위 테스트")
@ExtendWith(MockitoExtension.class)
class CommentCreateService_writeTest extends CommentMock {

    @InjectMocks
    CommentCreateService createService;

    @BeforeEach
    void setup() {
        saveCommentMocking();
    }

    @Test
    @DisplayName("댓글 작성 성공")
    void no1() {
        Long
                postWriterId = 1L,
                memberId = 2L;
        Post post = createPost(postWriterId);

        createService.write(memberId, "hello", post);

        assertThat(post.getCommentCount()).isEqualTo(1);
    }
}