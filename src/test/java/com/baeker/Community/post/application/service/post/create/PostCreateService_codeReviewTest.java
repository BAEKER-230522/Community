package com.baeker.Community.post.application.service.post.create;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.exception.feign.FeignClientException;
import com.baeker.Community.global.exception.service.InvalidDuplicateException;
import com.baeker.Community.post.application.service.post.PostCreateService;
import com.baeker.Community.post.application.service.repositoryMock.PostMock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("단위 - 코드 리뷰 게시글 작성")
@ExtendWith(MockitoExtension.class)
class PostCreateService_codeReviewTest extends PostCreateMock {

    @InjectMocks
    PostCreateService createService;

    @BeforeEach
    void setup() {
        savePostMocking();
        memberCheckMocking();
        newPostCheckMocking();
    }

    @Test
    @DisplayName("게시글 작성 성공")
    void no1() {
        Long
                memberId = 1L,
                problemStatusId = 1L;
        CreateCodeReviewDto dto = getCodeReviewDto(problemStatusId);


        createService.codeReview(memberId, dto);
    }

    @Test
    @DisplayName("이미 등록된 게시물일 경우")
    void no2() {
        Long
                memberId = 1L,
                problemStatusId = 3L;
        CreateCodeReviewDto dto = getCodeReviewDto(problemStatusId);


        assertThatThrownBy(() -> createService.codeReview(memberId, dto))
                .isInstanceOf(InvalidDuplicateException.class)
                .hasMessageContaining("이미 등록된 게시물");
    }

    @Test
    @DisplayName("가입한 스터디원이 아닐 경우")
    void no3() {
        Long
                memberId = 1L,
                studyId = 2L,
                problemStatusId = 1L;
        CreateCodeReviewDto dto = getCodeReviewDto(problemStatusId, studyId);


        assertThatThrownBy(() -> createService.codeReview(memberId, dto))
                .isInstanceOf(FeignClientException.class)
                .hasMessageContaining("잘못된 요청입니다.");
    }



    private CreateCodeReviewDto getCodeReviewDto(Long problemStatusId) {
        return new CreateCodeReviewDto(1L, 1L, problemStatusId, "java", "post", "hello");
    }

    private CreateCodeReviewDto getCodeReviewDto(Long problemStatusId, Long studyId) {
        return new CreateCodeReviewDto(studyId, 1L, problemStatusId, "java", "post", "hello");
    }
}