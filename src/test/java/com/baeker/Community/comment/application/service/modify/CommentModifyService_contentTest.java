package com.baeker.Community.comment.application.service.modify;

import com.baeker.Community.comment.application.service.CommentModifyService;
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

import static com.baeker.Community.global.testUtil.CreateObjectUnit.createComment;
import static com.baeker.Community.global.testUtil.CreateObjectUnit.createPost;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("단위 - 댓글 수정")
@ExtendWith(MockitoExtension.class)
class CommentModifyService_contentTest extends CommentMock {

    @InjectMocks
    CommentModifyService modifyService;

    @BeforeEach
    void setup() {
        saveCommentMocking();
    }


    @Test
    @DisplayName("댓글 수정 성공")
    void no1() {
        Long
                memberId1 = 1L,
                memberId2 = 2L,
                postId = 1L,
                commentId = 1L;
        String content = "modify content";
        Post post = createPost(memberId1, postId);
        Comment comment = createComment(memberId2, commentId, post);


        modifyService.content(memberId2, comment, content);
    }

    @Test
    @DisplayName("수정 권한이 없는 경우")
    void no2() {
        Long
                memberId1 = 1L,
                memberId2 = 2L,
                postId = 1L,
                commentId = 1L;
        String content = "modify content";
        Post post = createPost(memberId1, postId);
        Comment comment = createComment(memberId2, commentId, post);


        assertThatThrownBy(() -> modifyService.content(memberId1, comment, content))
                .isInstanceOf(NoPermissionException.class)
                .hasMessageContaining("수정 권한이 없습니다.");
    }
}