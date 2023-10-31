package com.baeker.Community.post.adapter.in.modify;

import com.baeker.Community.global.testUtil.TestObject;
import com.baeker.Community.post.adapter.in.requestMock.ApiStudyClientMock;
import com.baeker.Community.post.application.port.in.codeReview.CodeReviewQueryUseCase;
import com.baeker.Community.post.domain.CodeReview;
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
import static com.baeker.Community.global.testUtil.TestApiUtil.createCodeReview;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 게시물 조회수 추가")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostModifyController_pageViewTest extends ApiStudyClientMock {

    @Autowired MockMvc mvc;
    @Autowired TestObject create;
    @Autowired CodeReviewQueryUseCase codeReviewQueryUseCase;

    @BeforeEach
    void setup() {
        memberCheckMocking();
    }


    @Test
    @DisplayName("조회수 증가 성공")
    void no1() throws Exception {
        Long postId = create.codeReview();
        CodeReview codeReview = codeReviewQueryUseCase.byId(postId);
        Long problemStatusId = codeReview.getProblemStatusId();


        ResultActions result = patch(mvc, POST_PUBLIC_URL +
                "/v1/pageView/{problemStatusId}", problemStatusId);

        result.andExpect(status().is2xxSuccessful());
        assertThat(codeReview.getPageView()).isEqualTo(1);
    }
}