package com.baeker.Community.comment.application.service;

import com.baeker.Community.comment.application.service.repositoryMock.CommentMock;
import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.exception.service.NoPermissionException;
import com.baeker.Community.post.domain.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.baeker.Community.global.testUtil.CreateObject.createComment;
import static com.baeker.Community.global.testUtil.CreateObject.createPost;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("단위 - 댓글 삭제")
@ExtendWith(MockitoExtension.class)
class CommentDeleteService_commentTest extends CommentMock {

    @InjectMocks
    CommentDeleteService deleteService;

    @BeforeEach
    void setup() {
        saveCommentMocking();
        deleteCommentMocking();
    }


    @Test
    @DisplayName("댓글 삭제 성공")
    void no1() {
        Long
                memberId = 1L,
                postId = 1L,
                commentId = 1L;
        Post post = createPost(memberId, postId);
        Comment comment = createComment(memberId, commentId, post);


        deleteService.comment(memberId, comment);


        assertThat(post.getCommentList().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("권한이 없는 경우")
    void no2() {
        Long
                memberId = 1L,
                postId = 1L,
                commentId = 1L;
        Post post = createPost(memberId, postId);
        Comment comment = createComment(memberId, commentId, post);


        assertThatThrownBy(() -> deleteService.comment(2L, comment))
                .isInstanceOf(NoPermissionException.class)
                .hasMessageContaining("권한이 없습니다.");
    }
}