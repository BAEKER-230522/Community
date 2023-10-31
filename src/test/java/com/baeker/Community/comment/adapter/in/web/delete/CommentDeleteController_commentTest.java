package com.baeker.Community.comment.adapter.in.web.delete;

import com.baeker.Community.global.testUtil.TestData;
import com.baeker.Community.post.adapter.in.requestMock.ApiStudyClientMock;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import com.baeker.Community.post.domain.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static com.baeker.Community.global.testUtil.MockMvcRequest.delete;
import static com.baeker.Community.global.testUtil.TestApiUtil.createCodeReview;
import static com.baeker.Community.global.testUtil.TestApiUtil.createComment;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 댓글 삭제")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class CommentDeleteController_commentTest extends ApiStudyClientMock {

    @Autowired MockMvc mvc;
    @Autowired PostQueryUseCase postQueryUseCase;

    @BeforeEach
    void setup() {
        memberCheckMocking();
    }

    @Test
    @DisplayName("댓글 삭제 성공")
    void no1() throws Exception {
        Long postId = createCodeReview(mvc, POST_USER_URL, 1, jwt1);
        Long commentId1 = createComment(mvc, COMMENT_USER_URL, postId, jwt2);
        Long commentId2 = createComment(mvc, COMMENT_USER_URL, postId, jwt3);


        ResultActions result = delete(mvc, COMMENT_USER_URL +
                "/v1/{commentId}", jwt2, commentId1);


        result.andExpect(status().is2xxSuccessful());

        Post post = postQueryUseCase.byId(postId);
        assertThat(post.getCommentList().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("삭제 권한이 없을 경우")
    void no2() throws Exception {
        Long postId = createCodeReview(mvc, POST_USER_URL, 1, jwt1);
        Long commentId = createComment(mvc, COMMENT_USER_URL, postId, jwt2);


        ResultActions result = delete(mvc, COMMENT_USER_URL +
                "/v1/{commentId}", jwt3, commentId);


        result.andExpect(status().isBadRequest());

        Post post = postQueryUseCase.byId(postId);
        assertThat(post.getCommentList().size()).isEqualTo(1);
    }
}