package com.baeker.Community.comment.adapter.in.web.modify;

import com.baeker.Community.global.dto.reqDto.ModifyCommentDto;
import com.baeker.Community.global.dto.resDto.CommentDto;
import com.baeker.Community.global.testUtil.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static com.baeker.Community.global.testUtil.MockMvcRequest.patch;
import static com.baeker.Community.global.testUtil.MockMvcRequest.toResDto;
import static com.baeker.Community.global.testUtil.TestApiUtil.createCodeReview;
import static com.baeker.Community.global.testUtil.TestApiUtil.createComment;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 댓글 수정")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class CommentModifyController_contentTest extends TestData {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("댓글 수정 성공")
    void no1() throws Exception {
        String modifyContent = "modify content";
        Long postId = createCodeReview(mvc, POST_USER_URL, 1, jwt1);
        Long commentId = createComment(mvc, COMMENT_USER_URL, postId, jwt2);
        ModifyCommentDto dto = new ModifyCommentDto(commentId, modifyContent);


        ResultActions result = patch(mvc, COMMENT_USER_URL +
                "/v1/content", jwt2, dto);


        result.andExpect(status().is2xxSuccessful());

        CommentDto resDto = toResDto(result, CommentDto.class);
        assertThat(resDto.getContent()).isEqualTo(modifyContent);
    }

    @Test
    @DisplayName("댓글 수정 권한이 없을 경우")
    void no2() throws Exception {
        String modifyContent = "modify content";
        Long postId = createCodeReview(mvc, POST_USER_URL, 1, jwt1);
        Long commentId = createComment(mvc, COMMENT_USER_URL, postId, jwt2);
        ModifyCommentDto dto = new ModifyCommentDto(commentId, modifyContent);


        ResultActions result = patch(mvc, COMMENT_USER_URL +
                "/v1/content", jwt1, dto);


        result
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errorMsg").value("수정 권한이 없습니다."));
    }
}