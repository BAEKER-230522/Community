package com.baeker.Community.post.adapter.in.query;

import com.baeker.Community.global.testUtil.TestData;
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

import static com.baeker.Community.global.testUtil.MockMvcRequest.get;
import static com.baeker.Community.global.testUtil.TestApiUtil.createCodeReview;
import static com.baeker.Community.global.testUtil.TestApiUtil.follow;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 게시물 추천 회원 목록 조회")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostQueryController_followerTest extends ApiStudyClientMock {

    @Autowired MockMvc mvc;
    @Autowired PostQueryUseCase postQueryUseCase;

    @BeforeEach
    void setup() {
        memberCheckMocking();
    }


    @Test
    @DisplayName("추천 회원 목록 조회 성공")
    void no1() throws Exception {
        Long postId = createCodeReview(mvc, POST_USER_URL, 1, jwt1);
        follow(mvc, POST_USER_URL, postId, jwt2);
        follow(mvc, POST_USER_URL, postId, jwt3);


        ResultActions result = get(mvc, POST_PUBLIC_URL +
                "/v1/follower/{postId}", postId);


        result.andExpect(status().is2xxSuccessful());

        Post post = postQueryUseCase.byId(postId);
        assertThat(post.getFollowCount()).isEqualTo(2);
        assertThat(post.getFollows().get(0)).isEqualTo(2L);
        assertThat(post.getFollows().get(1)).isEqualTo(3L);
    }

    @Test
    @DisplayName("추천 취소")
    void no2() throws Exception {
        Long postId = createCodeReview(mvc, POST_USER_URL, 1, jwt1);
        follow(mvc, POST_USER_URL, postId, jwt2);
        follow(mvc, POST_USER_URL, postId, jwt2);


        ResultActions result = get(mvc, POST_PUBLIC_URL +
                "/v1/follower/{postId}", postId);


        result.andExpect(status().is2xxSuccessful());

        Post post = postQueryUseCase.byId(postId);
        assertThat(post.getFollowCount()).isEqualTo(0);
    }
}