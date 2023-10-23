package com.baeker.Community.category.adapter.in.web;

import com.baeker.Community.category.application.prot.in.codeReview.CodeReviewQueryUseCase;
import com.baeker.Community.category.application.prot.out.CodeReviewQueryRepositoryPort;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.testUtil.TestData;
import com.baeker.Community.post.application.port.in.PostQueryUseCase;
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
import static com.baeker.Community.global.testUtil.RequestCreateObject.createCodeReview;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("스터디원 코드리뷰 게시글 목록 조회 통합 테스트")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class CodeReviewQueryController_missionTest extends TestData {

    @Autowired MockMvc mvc;
    @Autowired
    PostQueryUseCase postQueryUseCase;
    @Autowired CodeReviewQueryUseCase codeReviewQueryUseCase;
    @Autowired
    CodeReviewQueryRepositoryPort queryRepository;


    @Test
    @DisplayName("목록 조회 성공")
    void no1() throws Exception {
        Long
                missionId = 1L,
                memberId = 1L,
                problemStatusId1 = 1L,
                problemStatusId2 = 2L;
        createCodeReview(mvc, POST_USER_URL, missionId, problemStatusId1, 1, jwt1);
        createCodeReview(mvc, POST_USER_URL, missionId, problemStatusId2, 2, jwt1);


        ResultActions result = get(mvc, MISSION_PUBLIC_URL +
                "/v1/mission/{missionId}/{memberId}", missionId, memberId);


        result.andExpect(status().is2xxSuccessful());

        List<CodeReviewDto> resDtoList = toList(result, CodeReviewDto.class);
        assertThat(resDtoList.size()).isEqualTo(2);
        assertThat(resDtoList.get(0).getMemberId()).isEqualTo(1L);
        assertThat(resDtoList.get(1).getMemberId()).isEqualTo(2L);
    }
}