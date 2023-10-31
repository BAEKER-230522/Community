package com.baeker.Community.post.adapter.in.query;

import com.baeker.Community.global.dto.resDto.StudyPostDto;
import com.baeker.Community.global.testUtil.TestObject;
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

import java.util.List;

import static com.baeker.Community.global.testUtil.MockMvcRequest.get;
import static com.baeker.Community.global.testUtil.MockMvcRequest.toList;
import static com.baeker.Community.global.testUtil.TestApiUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - study id 로 게시물 목록 조회")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostQueryController_studyIdTest extends ApiStudyClientMock {

    @Autowired MockMvc mvc;
    @Autowired TestObject create;

    @BeforeEach
    void setup() {
        memberCheckMocking();
    }


    @Test
    @DisplayName("목록 조회 성공")
    void no1() throws Exception {
        Long
                member1 = 1L,
                member2 = 2L,
                member3 = 3L,
                studyId = 1L;
        Long postId1 = create.studyPost(member1, 1);
        Long postId2 = create.studyPost(member2, 2);
        create.comment(member3, postId1);
        create.follow(member3, postId2);


        ResultActions result = get(mvc, POST_PUBLIC_URL +
                "/v1/study/{studyId}", studyId);


        result
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("data").isArray())
                .andExpect(jsonPath("data", Matchers.iterableWithSize(2)))

                .andExpect(jsonPath("data[0].title").value("post1"))
                .andExpect(jsonPath("data[0].comments", Matchers.iterableWithSize(1)))
                .andExpect(jsonPath("data[0].comments[0].content").value("comment"))

                .andExpect(jsonPath("data[1].title").value("post2"))
                .andExpect(jsonPath("data[1].follower").value(1));
    }
}