package com.baeker.Community.post.adapter.in;

import com.baeker.Community.global.testUtil.MockMvcRequest;
import com.baeker.Community.global.testUtil.TestApiUtil;
import com.baeker.Community.global.testUtil.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static com.baeker.Community.global.testUtil.MockMvcRequest.get;
import static com.baeker.Community.global.testUtil.TestApiUtil.createCodeReview;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - mission 으로 게시물 목록 조회")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostQueryController_missionTest extends TestData {

    @Autowired
    MockMvc mvc;


    @Test
    @DisplayName("게시물 목록 조회 성공")
    void no1() throws Exception {
        Long
                missionId = 1L,
                memberId = 1L,
                problemStatusId1 = 1L,
                problemStatusId2 = 2L;
        createCodeReview(mvc, POST_USER_URL, missionId, problemStatusId1, 1, jwt1);
        createCodeReview(mvc, POST_USER_URL, missionId, problemStatusId2, 2, jwt1);


        ResultActions result = get(mvc, POST_PUBLIC_URL +
                "/v1/mission/{missionId}/{memberId}", missionId, memberId);


        result.andExpect(status().is2xxSuccessful());
    }
}