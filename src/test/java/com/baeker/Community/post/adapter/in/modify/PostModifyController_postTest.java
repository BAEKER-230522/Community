package com.baeker.Community.post.adapter.in.modify;

import com.baeker.Community.global.dto.reqDto.ModifyPostDto;
import com.baeker.Community.global.testUtil.TestObject;
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
import static com.baeker.Community.global.testUtil.TestApiUtil.createCodeReview;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 게시물 수정")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostModifyController_postTest extends ApiStudyClientMock {

    @Autowired MockMvc mvc;
    @Autowired TestObject create;

    @BeforeEach
    void setup() {
        memberCheckMocking();
    }


    @Test
    @DisplayName("게시물 수정 성공")
    void no1() throws Exception {
        Long postId = create.codeReview();
        ModifyPostDto dto = new ModifyPostDto(postId, "modify title", "modify content");


        ResultActions result = patch(mvc, POST_USER_URL +
                "/v1/post", jwt1, dto);


        result
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("data.title").value("modify title"))
                .andExpect(jsonPath("data.content").value("modify content"));
    }

    @Test
    @DisplayName("게시글 수정 권한이 없는 경우")
    void no2() throws Exception {
        Long memberId = 1L;
        Long postId = create.codeReview(memberId);
        ModifyPostDto dto = new ModifyPostDto(postId, "modify title", "modify content");


        ResultActions result = patch(mvc, POST_USER_URL +
                "/v1/post", jwt2, dto);


        result
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errorMsg").value("권한이 없습니다."));
    }
}