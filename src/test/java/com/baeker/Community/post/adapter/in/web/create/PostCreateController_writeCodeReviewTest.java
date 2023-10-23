package com.baeker.Community.post.adapter.in.web.create;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.testUtil.MockMvcRequest;
import com.baeker.Community.global.testUtil.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static com.baeker.Community.global.testUtil.MockMvcRequest.post;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("코드리뷰 게시물 작성 통합 테스트")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostCreateController_writeCodeReviewTest extends TestData {

    @Autowired MockMvc mvc;


    @Test
    @DisplayName("코드리뷰 게시물 등록 성공")
    void no1() throws Exception{
        Long
                missionId = 1L,
                problemStatusId = 1L;
        String
                title = "code review",
                content = "hello";
        CreateCodeReviewDto dto = toDto(missionId, problemStatusId, title, content);


        ResultActions result = post(mvc, POST_USER_URL +
                "/v1/code-review", jwt1, dto);


        result.andExpect(status().is2xxSuccessful());

        CodeReviewDto resDto = MockMvcRequest.toResDto(result, CodeReviewDto.class);
        assertThat(resDto.getTitle()).isEqualTo(title);
        assertThat(resDto.getContent()).isEqualTo(content);
        assertThat(resDto.getProblemStatusId()).isEqualTo(problemStatusId);
    }

    private CreateCodeReviewDto toDto(Long missionId, Long problemStatusId, String title, String content) {
        return new CreateCodeReviewDto(missionId, problemStatusId, title, content);
    }
}