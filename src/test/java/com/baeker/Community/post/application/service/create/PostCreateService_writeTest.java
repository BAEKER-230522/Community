package com.baeker.Community.post.application.service.create;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.post.application.service.post.PostCreateService;
import com.baeker.Community.post.application.service.repositoryMock.PostMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("단위: 코드 리뷰 게시글 작성")
@ExtendWith(MockitoExtension.class)
class PostCreateService_writeTest extends PostMock {

    @InjectMocks
    PostCreateService createService;

    @BeforeEach
    void setup() {
        savePostMocking();
    }

    @Test
    @DisplayName("게시글 작성 성공")
    void no1() {
        Long memberId = 1L;
        CreateCodeReviewDto dto = getCodeReviewDto();


        createService.codeReview(memberId, dto);
    }


    private CreateCodeReviewDto getCodeReviewDto() {
        return new CreateCodeReviewDto(1L, 1L, "post", "hello");
    }

}