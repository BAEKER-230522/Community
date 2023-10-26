package com.baeker.Community.post.adapter.in.modify;

import com.baeker.Community.global.testUtil.TestData;
import com.baeker.Community.post.application.port.in.codeReview.CodeReviewQueryUseCase;
import com.baeker.Community.post.domain.CodeReview;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static com.baeker.Community.global.testUtil.MockMvcRequest.patch;
import static com.baeker.Community.global.testUtil.TestApiUtil.createCodeReview;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 게시물 조회수 추가")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostModifyController_pageViewTest extends TestData {

    @Autowired MockMvc mvc;
    @Autowired CodeReviewQueryUseCase codeReviewQueryUseCase;

    @Test
    @DisplayName("조회수 증가 성공")
    void no1() throws Exception {
        Long postId = createCodeReview(mvc, POST_USER_URL, 1, jwt1);
        CodeReview codeReview = codeReviewQueryUseCase.byId(postId);
        Long problemStatusId = codeReview.getProblemStatusId();


        ResultActions result = patch(mvc, POST_PUBLIC_URL +
                "/v1/pageView/{problemStatusId}", problemStatusId);

        result.andExpect(status().is2xxSuccessful());
        assertThat(codeReview.getPageView()).isEqualTo(1);
    }
}