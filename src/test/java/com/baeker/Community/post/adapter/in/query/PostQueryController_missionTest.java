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
import static com.baeker.Community.global.testUtil.MockMvcRequest.toList;
import static com.baeker.Community.global.testUtil.TestApiUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
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
        Long postId1 = createCodeReview(mvc, POST_USER_URL, missionId, problemStatusId1, 1, jwt1);
        Long postId2 = createCodeReview(mvc, POST_USER_URL, missionId, problemStatusId2, 2, jwt1);
        createComment(mvc, COMMENT_USER_URL, postId1, jwt2);
        follow(mvc, POST_USER_URL, postId2, jwt2);


        ResultActions result = get(mvc, POST_PUBLIC_URL +
                "/v1/mission/{missionId}/{memberId}", missionId, memberId);


        result.andExpect(status().is2xxSuccessful());

        List<CodeReviewDto> resDtos = toList(result, CodeReviewDto.class);
        assertThat(resDtos.size()).isEqualTo(2);

        List<CommentDto> comments = resDtos.get(0).getComments();
        assertThat(comments.size()).isEqualTo(1);
        assertThat(comments.get(0).getContent()).isEqualTo("comment");

        CodeReviewDto codeReview2 = resDtos.get(1);
        assertThat(codeReview2.getFollower()).isEqualTo(1);
    }
}