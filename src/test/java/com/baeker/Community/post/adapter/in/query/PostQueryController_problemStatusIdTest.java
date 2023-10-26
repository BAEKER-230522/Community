package com.baeker.Community.post.adapter.in.query;

import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.dto.resDto.CommentDto;
import com.baeker.Community.global.testUtil.TestData;
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
import static com.baeker.Community.global.testUtil.MockMvcRequest.toResDto;
import static com.baeker.Community.global.testUtil.TestApiUtil.createCodeReview;
import static com.baeker.Community.global.testUtil.TestApiUtil.createComment;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 코드리뷰 조회")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostQueryController_problemStatusIdTest extends TestData {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("problem status id 로 조회 성공")
    void no1() throws Exception {
        Long
                missionId = 1L,
                problemStatusId = 1L;
        Long postId = createCodeReview(mvc, POST_USER_URL, missionId, problemStatusId, 1, jwt1);
        createComment(mvc, COMMENT_USER_URL, postId, jwt2);


        ResultActions result = get(mvc, POST_PUBLIC_URL +
                "/v1/problem-status/{problemStatusId}", problemStatusId);


        result.andExpect(status().is2xxSuccessful());

        CodeReviewDto resDto = toResDto(result, CodeReviewDto.class);
        assertThat(resDto.getMissionId()).isEqualTo(missionId);
        assertThat(resDto.getProblemStatusId()).isEqualTo(problemStatusId);
        assertThat(resDto.getTitle()).isEqualTo("post1");
        assertThat(resDto.getPageView()).isEqualTo(1);

        List<CommentDto> comments = resDto.getComments();
        assertThat(comments.size()).isEqualTo(1);
        assertThat(comments.get(0).getContent()).isEqualTo("comment");
    }
}