package com.baeker.Community.post.adapter.in.create;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.testUtil.MockMvcRequest;
import com.baeker.Community.global.testUtil.TestData;
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

import static com.baeker.Community.global.testUtil.MockMvcRequest.post;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 코드리뷰 게시물 작성")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostCreateController_codeReviewTest extends ApiStudyClientMock {

    @Autowired MockMvc mvc;

    @BeforeEach
    void setup() {
        memberCheckMocking();
    }


    @Test
    @DisplayName("코드리뷰 게시물 등록 성공")
    void no1() throws Exception{
        Long
                studyId = 1L,
                missionId = 1L,
                problemStatusId = 1L;
        String
                title = "code review",
                content = "hello";
        CreateCodeReviewDto dto = toDto(studyId, missionId, problemStatusId, title, content);


        ResultActions result = post(mvc, POST_USER_URL +
                "/v1/code-review", jwt1, dto);


        result.andExpect(status().is2xxSuccessful());

        CodeReviewDto resDto = MockMvcRequest.toResDto(result, CodeReviewDto.class);
        assertThat(resDto.getTitle()).isEqualTo(title);
        assertThat(resDto.getContent()).isEqualTo(content);
        assertThat(resDto.getProblemStatusId()).isEqualTo(problemStatusId);
    }

    @Test
    @DisplayName("이미 게시물을 등록한 경우")
    void n02() throws Exception {
        Long problemStatusId = 1L;
        CreateCodeReviewDto dto = toDto(problemStatusId);
        post(mvc, POST_USER_URL + "/v1/code-review", jwt1, dto);


        ResultActions result = post(mvc, POST_USER_URL +
                "/v1/code-review", jwt1, dto);


        result
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errorMsg").value("이미 등록된 게시물"));
    }



    private CreateCodeReviewDto toDto(Long studyId, Long missionId, Long problemStatusId, String title, String content) {
        return new CreateCodeReviewDto(studyId, missionId, problemStatusId, title, content);
    }

    private CreateCodeReviewDto toDto(Long problemStatusId) {
        return new CreateCodeReviewDto(1L, 1L, problemStatusId, "title", "content");
    }
}