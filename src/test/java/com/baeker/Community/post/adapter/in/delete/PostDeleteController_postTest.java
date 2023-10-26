package com.baeker.Community.post.adapter.in.delete;

import com.baeker.Community.comment.application.port.in.CommentQueryUseCase;
import com.baeker.Community.global.dto.resDto.StudyPostDto;
import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.global.testUtil.TestData;
import com.baeker.Community.post.application.port.in.study.StudyPostQueryUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.baeker.Community.global.testUtil.MockMvcRequest.delete;
import static com.baeker.Community.global.testUtil.TestApiUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("통합 - 게시물 삭제")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostDeleteController_postTest extends TestData {

    @Autowired MockMvc mvc;
    @Autowired StudyPostQueryUseCase studyPostQueryUseCase;
    @Autowired CommentQueryUseCase commentQueryUseCase;


    @Test
    @DisplayName("게시글 삭제 성공")
    void no1() throws Exception {
        Long studyId = 1L;
        createStudyPost(mvc, POST_USER_URL, studyId, 1, jwt1);
        Long postId = createStudyPost(mvc, POST_USER_URL, studyId, 2, jwt2);


        ResultActions result = delete(mvc, POST_USER_URL +
                "/v1/{postId}", jwt2, postId);


        result.andExpect(status().is2xxSuccessful());

        List<StudyPostDto> posts = studyPostQueryUseCase.byStudyId(studyId);
        assertThat(posts.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("추천이 있는 게시물 삭제 성공")
    void no2() throws Exception {
        Long studyId = 1L;
        Long postId = createStudyPost(mvc, POST_USER_URL, studyId, 1, jwt1);
        follow(mvc, POST_USER_URL, postId, jwt2);
        follow(mvc, POST_USER_URL, postId, jwt3);


        ResultActions result = delete(mvc, POST_USER_URL +
                "/v1/{postId}", jwt1, postId);

        result.andExpect(status().is2xxSuccessful());
        assertThatThrownBy(() -> studyPostQueryUseCase.byStudyId(studyId))
                .isInstanceOf(NotFoundException.class)
                .hasMessageContaining("등록된 게시물이 없습니다.");
    }

    @Test
    @DisplayName("댓글이 있는 게시물 삭제 성공")
    void no3() throws Exception {
        Long studyId = 1L;
        Long postId = createStudyPost(mvc, POST_USER_URL, studyId, 1, jwt1);
        Long commentId = createComment(mvc, COMMENT_USER_URL, postId, jwt2);
        createComment(mvc, COMMENT_USER_URL, postId, jwt3);


        ResultActions result = delete(mvc, POST_USER_URL +
                "/v1/{postId}", jwt1, postId);

        result.andExpect(status().is2xxSuccessful());
        assertThatThrownBy(() -> studyPostQueryUseCase.byStudyId(studyId))
                .isInstanceOf(NotFoundException.class)
                .hasMessageContaining("등록된 게시물이 없습니다.");

        assertThatThrownBy(() -> commentQueryUseCase.byId(commentId))
                .isInstanceOf(NotFoundException.class)
                .hasMessageContaining("존재하지 않는 댓글");
    }

    @Test
    @DisplayName("삭제 권한이 없을 경우")
    void no4() throws Exception {
        Long studyId = 1L;
        Long postId = createStudyPost(mvc, POST_USER_URL, studyId, 1, jwt1);


        ResultActions result = delete(mvc, POST_USER_URL +
                "/v1/{postId}", jwt2, postId);


        result
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errorMsg").value("권한이 없습니다."));
    }
}