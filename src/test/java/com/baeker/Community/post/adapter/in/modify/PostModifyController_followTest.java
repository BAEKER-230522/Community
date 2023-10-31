package com.baeker.Community.post.adapter.in.modify;

import com.baeker.Community.global.testUtil.CreateObject;
import com.baeker.Community.post.adapter.in.requestMock.ApiStudyClientMock;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import com.baeker.Community.post.domain.Post;
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
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 게시물 추천")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostModifyController_followTest extends ApiStudyClientMock {

    @Autowired MockMvc mvc;
    @Autowired
    CreateObject create;
    @Autowired PostQueryUseCase postQueryUseCase;

    @BeforeEach
    void setup() {
        memberCheckMocking();
    }


    @Test
    @DisplayName("게시물 추천 성공")
    void no1() throws Exception {
        Long
                memberId = 1L,
                missionId = 1L,
                problemStatusId = 1L;
        Long postId = create.codeReview(memberId, missionId, problemStatusId, 1);


        ResultActions result = patch(mvc, POST_USER_URL +
                "/v1/follow/{postId}", jwt2, postId);


        result.andExpect(status().is2xxSuccessful());

        Post post = postQueryUseCase.byId(postId);
        assertThat(post.getFollowCount()).isEqualTo(1);
        assertThat(post.getFollows().get(0)).isEqualTo(2L);
    }

    @Test
    @DisplayName("게시물 추천 취소")
    void no2() throws Exception {
        Long postId = create.codeReview(1L, 1L, 1L, 1);
        create.follow(2L, postId);


        ResultActions result = patch(mvc, POST_USER_URL + "/v1/follow/{postId}", jwt2, postId);


        result.andExpect(status().is2xxSuccessful());

        Post post = postQueryUseCase.byId(postId);
        assertThat(post.getFollowCount()).isEqualTo(0);
    }
}