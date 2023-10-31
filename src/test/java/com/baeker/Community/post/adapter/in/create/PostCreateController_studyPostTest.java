package com.baeker.Community.post.adapter.in.create;

import com.baeker.Community.global.dto.reqDto.CreateStudyPostDto;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 스터디 전용 게시물 생성")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostCreateController_studyPostTest extends ApiStudyClientMock {

    @Autowired
    MockMvc mvc;

    @BeforeEach
    void setup() {
        memberCheckMocking();
    }


    @Test
    @DisplayName("게시물 생성 성공")
    void no1() throws Exception {
        Long studyId = 1L;
        String
                title = "study post",
                content = "content";
        CreateStudyPostDto dto = new CreateStudyPostDto(studyId, title, content);


        ResultActions result = post(mvc, POST_USER_URL + "/v1/study", jwt1, dto);


        result.andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("data.studyId").value(studyId))
                .andExpect(jsonPath("data.title").value(title))
                .andExpect(jsonPath("data.content").value(content));
    }
}