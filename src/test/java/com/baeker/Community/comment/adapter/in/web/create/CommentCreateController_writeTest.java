package com.baeker.Community.comment.adapter.in.web.create;

import com.baeker.Community.global.dto.reqDto.CreateCommentReqDto;
import com.baeker.Community.global.testUtil.TestData;
import com.baeker.Community.post.application.port.in.PostQueryUseCase;
import com.baeker.Community.post.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static com.baeker.Community.global.testUtil.MockMvcRequest.post;
import static com.baeker.Community.global.testUtil.RequestCreateObject.createCodeReview;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("댓글 작성 통합 테스트")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class CommentCreateController_writeTest extends TestData {

    @Autowired MockMvc mvc;
    @Autowired PostQueryUseCase postQueryUseCase;

    @Test
    @DisplayName("댓글 작성 성공")
    void no1() throws Exception {
        Long postId = createCodeReview(mvc, POST_USER_URL, 1, jwt1);
        CreateCommentReqDto reqDto = new CreateCommentReqDto(postId, "comment");


        ResultActions result = post(mvc, COMMENT_USER_URL + "/v1", jwt2, reqDto);


        result.andExpect(status().is2xxSuccessful());

        Post post = postQueryUseCase.byId(postId);
        assertThat(post.getCommentCount()).isEqualTo(1);
        assertThat(post.getCommentList().get(0).getMemberId()).isEqualTo(2L);
        assertThat(post.getCommentList().get(0).getContent()).isEqualTo("comment");
    }
}