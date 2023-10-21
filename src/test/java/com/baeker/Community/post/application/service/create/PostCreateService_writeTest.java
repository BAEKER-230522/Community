package com.baeker.Community.post.application.service.create;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.post.application.service.PostCreateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("코드 리뷰 게시글 작성 단위 테스트")
@ExtendWith(MockitoExtension.class)
class PostCreateService_writeTest extends PostCreateMock {

    @InjectMocks
    PostCreateService createService;

    @BeforeEach
    void setup() {
        writeCodeReviewMocking();
        savePostMocking();
    }

    @Test
    @DisplayName("게시글 작성 성공")
    void no1() {
        Long memberId = 1L;
        CreateCodeReviewDto dto = getCodeReviewDto();


        createService.write(memberId, dto);
    }


    private CreateCodeReviewDto getCodeReviewDto() {
        return new CreateCodeReviewDto(1L, 1L, "post", "hello");
    }

}