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

@DisplayName("통합 - mission 으로 게시물 목록 조회")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostQueryController_missionTest extends ApiStudyClientMock {

    @Autowired MockMvc mvc;
    @Autowired
    CreateObject create;

    @BeforeEach
    void setup() {
        memberCheckMocking();
    }


    @Test
    @DisplayName("게시물 목록 조회 성공")
    void no1() throws Exception {
        Long
                member1 = 1L,
                member2 = 2L,
                missionId = 1L,
                memberId = 1L,
                problemStatusId1 = 1L,
                problemStatusId2 = 2L;
        Long postId1 = create.codeReview(member1, missionId, problemStatusId1, 1);
        Long postId2 = create.codeReview(member1, missionId, problemStatusId2, 2);
        create.comment(member2, postId1);
        create.follow(member2, postId2);


        ResultActions result = get(mvc, POST_PUBLIC_URL +
                "/v1/mission/{missionId}/{memberId}", missionId, memberId);


        result.andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("data", Matchers.iterableWithSize(2)))

                .andExpect(jsonPath("data[0].comments", Matchers.iterableWithSize(1)))
                .andExpect(jsonPath("data[0].comments[0].content").value("comment"))

                .andExpect(jsonPath("data[1].follower").value(1));
    }
}