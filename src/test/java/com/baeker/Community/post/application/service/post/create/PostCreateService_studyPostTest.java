package com.baeker.Community.post.application.service.post.create;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.reqDto.CreateStudyPostDto;
import com.baeker.Community.global.exception.feign.FeignClientException;
import com.baeker.Community.post.application.service.post.PostCreateService;
import com.baeker.Community.post.application.service.repositoryMock.PostMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("단위 - 스터디 전용 게시물 생성")
@ExtendWith(MockitoExtension.class)
class PostCreateService_studyPostTest extends PostMock {

    @InjectMocks
    PostCreateService createService;

    @BeforeEach
    void setup() {
        savePostMocking();
        memberCheckMocking();
    }


    @Test
    @DisplayName("게시글 작성 성공")
    void no1() {
        Long
                memberId = 1L,
                studyId = 1L;
        CreateStudyPostDto dto = getStudyPostDto(studyId);


        createService.studyPost(memberId, dto);
    }


    private CreateStudyPostDto getStudyPostDto(Long studyId) {
        return new CreateStudyPostDto(studyId, "post", "content");
    }

    @Test
    @DisplayName("가입한 스터디원이 아닐 경우")
    void no2() {
        Long
                memberId = 1L,
                studyId = 2L;
        CreateStudyPostDto dto = getStudyPostDto(studyId);


        assertThatThrownBy(() -> createService.studyPost(memberId, dto))
                .isInstanceOf(FeignClientException.class)
                .hasMessageContaining("잘못된 요청입니다.");
    }
}