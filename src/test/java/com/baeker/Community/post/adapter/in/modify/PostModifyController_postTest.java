package com.baeker.Community.post.adapter.in.modify;

import com.baeker.Community.global.dto.reqDto.ModifyPostDto;
import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.global.testUtil.MockMvcRequest;
import com.baeker.Community.global.testUtil.TestApiUtil;
import com.baeker.Community.global.testUtil.TestData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static com.baeker.Community.global.testUtil.MockMvcRequest.patch;
import static com.baeker.Community.global.testUtil.MockMvcRequest.toResDto;
import static com.baeker.Community.global.testUtil.TestApiUtil.createCodeReview;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 게시물 수정")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostModifyController_postTest extends TestData {

    @Autowired
    MockMvc mvc;


    @Test
    @DisplayName("게시물 수정 성공")
    void no1() throws Exception {
        Long postId = createCodeReview(mvc, POST_USER_URL, 1, jwt1);
        ModifyPostDto dto = new ModifyPostDto(postId, "modify title", "modify content");


        ResultActions result = patch(mvc, POST_USER_URL +
                "/v1/post", jwt1, dto);


        result.andExpect(status().is2xxSuccessful());

        PostDto resDto = toResDto(result, PostDto.class);
        assertThat(resDto.getTitle()).isEqualTo("modify title");
        assertThat(resDto.getContent()).isEqualTo("modify content");
    }

    @Test
    @DisplayName("게시글 수정 권한이 없는 경우")
    void no2() throws Exception {
        Long postId = createCodeReview(mvc, POST_USER_URL, 1, jwt1);
        ModifyPostDto dto = new ModifyPostDto(postId, "modify title", "modify content");


        ResultActions result = patch(mvc, POST_USER_URL +
                "/v1/post", jwt2, dto);


        result
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errorMsg").value("권한이 없습니다."));
    }
}