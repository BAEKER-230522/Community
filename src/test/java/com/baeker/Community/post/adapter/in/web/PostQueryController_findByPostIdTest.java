package com.baeker.Community.post.adapter.in.web;

import com.baeker.Community.global.dto.resDto.CommentDto;
import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.global.testUtil.MockMvcRequest;
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
import static com.baeker.Community.global.testUtil.RequestCreateObject.createCodeReview;
import static com.baeker.Community.global.testUtil.RequestCreateObject.createComment;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합: post id 로 게시물 조회")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostQueryController_findByPostIdTest extends TestData {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("조회 성공")
    void no1() throws Exception {
        Long postId = createCodeReview(mvc, POST_USER_URL, 1, jwt1);
        createComment(mvc, COMMENT_USER_URL, postId, jwt2);


        ResultActions result = get(mvc, POST_PUBLIC_URL + "/v1/post/{postId}", postId);


        result.andExpect(status().is2xxSuccessful());

        List<CommentDto> comments = MockMvcRequest.toResDto(result, PostDto.class).getComments();
        assertThat(comments.size()).isEqualTo(1);
        assertThat(comments.get(0).getContent()).isEqualTo("comment");

    }
}