package com.baeker.Community.comment.adapter.in.web.modify;

import com.baeker.Community.global.dto.reqDto.ModifyCommentDto;
import com.baeker.Community.global.testUtil.CreateObject;
import com.baeker.Community.post.adapter.in.requestMock.ApiStudyClientMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static com.baeker.Community.global.testUtil.MockMvcRequest.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 댓글 수정")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class CommentModifyController_contentTest extends ApiStudyClientMock {

    @Autowired MockMvc mvc;
    @Autowired
    CreateObject create;

    @BeforeEach
    void setup() {
        memberCheckMocking();
    }


    @Test
    @DisplayName("댓글 수정 성공")
    void no1() throws Exception {
        String modifyContent = "modify content";
        Long postId = create.codeReview();
        Long commentId = create.comment(2L, postId);
        ModifyCommentDto dto = new ModifyCommentDto(commentId, modifyContent);


        ResultActions result = patch(mvc, COMMENT_USER_URL +
                "/v1/content", jwt2, dto);


        result
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("data.content").value(modifyContent));
    }

    @Test
    @DisplayName("댓글 수정 권한이 없을 경우")
    void no2() throws Exception {
        String modifyContent = "modify content";
        Long postId = create.codeReview();
        Long commentId = create.comment(2L, postId);
        ModifyCommentDto dto = new ModifyCommentDto(commentId, modifyContent);


        ResultActions result = patch(mvc, COMMENT_USER_URL +
                "/v1/content", jwt1, dto);


        result
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errorMsg").value("수정 권한이 없습니다."));
    }
}