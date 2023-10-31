package com.baeker.Community.post.adapter.in.query;

import com.baeker.Community.global.testUtil.CreateObject;
import com.baeker.Community.post.adapter.in.requestMock.ApiStudyClientMock;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import com.baeker.Community.post.domain.Post;
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
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 게시물 추천 회원 목록 조회")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostQueryController_followerTest extends ApiStudyClientMock {

    @Autowired MockMvc mvc;
    @Autowired
    CreateObject create;
    @Autowired PostQueryUseCase postQueryUseCase;

    @BeforeEach
    void setup() {
        memberCheckMocking();
    }


    @Test
    @DisplayName("추천 회원 목록 조회 성공")
    void no1() throws Exception {
        Long
                member1 = 1L,
                member2 = 2L,
                member3 = 3L;
        Long postId = create.codeReview(member1);
        create.follow(member2, postId);
        create.follow(member3, postId);


        ResultActions result = get(mvc, POST_PUBLIC_URL +
                "/v1/follower/{postId}", postId);


        result
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("data", Matchers.iterableWithSize(2)))
                .andExpect(jsonPath("data[0]").value(2L))
                .andExpect(jsonPath("data[1]").value(3L));
    }

    @Test
    @DisplayName("추천 취소")
    void no2() throws Exception {
        Long
                member1 = 1L,
                member2 = 2L;
        Long postId = create.codeReview(member1);
        create.follow(member2, postId);
        create.follow(member2, postId);


        ResultActions result = get(mvc, POST_PUBLIC_URL +
                "/v1/follower/{postId}", postId);


        result.andExpect(status().is2xxSuccessful());

        Post post = postQueryUseCase.byId(postId);
        assertThat(post.getFollowCount()).isEqualTo(0);
    }
}