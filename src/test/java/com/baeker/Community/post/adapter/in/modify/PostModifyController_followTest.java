package com.baeker.Community.post.adapter.in.modify;

import com.baeker.Community.global.testUtil.TestData;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import com.baeker.Community.post.domain.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static com.baeker.Community.global.testUtil.MockMvcRequest.patch;
import static com.baeker.Community.global.testUtil.RequestCreateObject.createCodeReview;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 게시물 추천")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostModifyController_followTest extends TestData {

    @Autowired MockMvc mvc;
    @Autowired PostQueryUseCase postQueryUseCase;

    @Test
    @DisplayName("게시물 추천 성공")
    void no1() throws Exception {
        Long
                missionId = 1L,
                problemStatusId = 1L;
        Long postId = createCodeReview(mvc, POST_USER_URL, missionId, problemStatusId, 1, jwt1);


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
        Long postId = createCodeReview(mvc, POST_USER_URL, 1, jwt1);
        patch(mvc, POST_USER_URL + "/v1/follow/{postId}", jwt2, postId);


        ResultActions result = patch(mvc, POST_USER_URL + "/v1/follow/{postId}", jwt2, postId);

        result.andExpect(status().is2xxSuccessful());

        Post post = postQueryUseCase.byId(postId);
        assertThat(post.getFollowCount()).isEqualTo(0);
    }
}