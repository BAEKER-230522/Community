package com.baeker.Community.post.adapter.in.query;

import com.baeker.Community.global.dto.resDto.StudyPostDto;
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

@DisplayName("통합 - study id 로 게시물 목록 조회")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PostQueryController_studyIdTest extends TestData {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("목록 조회 성공")
    void no1() throws Exception {
        Long studyId = 1L;
        Long postId1 = createStudyPost(mvc, POST_USER_URL, studyId, 1, jwt1);
        Long postId2 = createStudyPost(mvc, POST_USER_URL, studyId, 2, jwt2);
        createComment(mvc, COMMENT_USER_URL, postId1, jwt3);
        follow(mvc, POST_USER_URL, postId2, jwt3);


        ResultActions result = get(mvc, POST_PUBLIC_URL +
                "/v1/study/{studyId}", studyId);


        result.andExpect(status().is2xxSuccessful());

        List<StudyPostDto> resDtos = toList(result, StudyPostDto.class);
        assertThat(resDtos.size()).isEqualTo(2);
        assertThat(resDtos.get(0).getTitle()).isEqualTo("post1");
        assertThat(resDtos.get(0).getComments().size()).isEqualTo(1);
        assertThat(resDtos.get(0).getComments().get(0).getContent()).isEqualTo("comment");

        assertThat(resDtos.get(1).getTitle()).isEqualTo("post2");
        assertThat(resDtos.get(1).getFollower()).isEqualTo(1);
    }
}