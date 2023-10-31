package com.baeker.Community.post.adapter.in;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.testUtil.MockMvcRequest;
import com.baeker.Community.post.adapter.in.requestMock.ApiStudyClientMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static com.baeker.Community.global.testUtil.MockMvcRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 크기가 큰 게시물 저장")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostCreateController_postLengthTest extends ApiStudyClientMock {

    @Autowired
    MockMvc mvc;

    @BeforeEach
    void setup() {
        memberCheckMocking();
    }


    @Test
    @DisplayName("길이가 긴 게시물 저장 성공")
    void no1() throws Exception {
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < 1000; i++) content.append(i);
        CreateCodeReviewDto dto = createDto(content.toString());


        ResultActions result = post(mvc, POST_USER_URL +
                "/v1/code-review", jwt1, dto);


        result
                .andExpect(status().is2xxSuccessful());
    }



    private static CreateCodeReviewDto createDto(String content) {
        return new CreateCodeReviewDto(1L, 1L, 1L, "post", content);
    }
}