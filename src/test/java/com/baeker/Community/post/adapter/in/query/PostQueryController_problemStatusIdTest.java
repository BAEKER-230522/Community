package com.baeker.Community.post.adapter.in.query;

import com.baeker.Community.global.testUtil.CreateObject;
import com.baeker.Community.post.adapter.in.requestMock.ApiStudyClientMock;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static com.baeker.Community.global.testUtil.MockMvcRequest.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 코드리뷰 조회")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostQueryController_problemStatusIdTest extends ApiStudyClientMock {

    @Autowired MockMvc mvc;
    @Autowired
    CreateObject create;

    @BeforeEach
    void setup() {
        memberCheckMocking();
    }


    @Test
    @DisplayName("problem status id 로 조회 성공")
    void no1() throws Exception {
        Long
                memberId = 1L,
                missionId = 1L,
                problemStatusId = 1L;
        Long postId = create.codeReview(memberId, missionId, problemStatusId, 1);
        create.comment(memberId, postId);


        ResultActions result = get(mvc, POST_PUBLIC_URL +
                "/v1/problem-status/{problemStatusId}", problemStatusId);


        result
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("data.missionId").value(missionId))
                .andExpect(jsonPath("data.problemStatusId").value(problemStatusId))
                .andExpect(jsonPath("data.title").value("post1"))
                .andExpect(jsonPath("data.pageView").value(1))


                .andExpect(jsonPath("data.comments", Matchers.iterableWithSize(1)))
                .andExpect(jsonPath("data.comments[0].content").value("comment"));
    }
}