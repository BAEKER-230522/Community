package com.baeker.Community.category.application.service.codeReview.create;

import com.baeker.Community.category.application.service.codeReview.CodeReviewCreateService;
import com.baeker.Community.category.application.service.codeReview.repository.CodeReviewMock;
import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.testUtil.CreateObject;
import com.baeker.Community.post.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.baeker.Community.global.testUtil.CreateObject.createPost;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("코드리뷰 게시물 작성")
@ExtendWith(MockitoExtension.class)
class CodeReviewCreateService_writeTest extends CodeReviewMock {

    @InjectMocks
    CodeReviewCreateService createService;


    @BeforeEach
    void setup() {
        saveCodeReviewMocking();
    }

    @Test
    @DisplayName("코드리뷰 게시물 생성 성공")
    void no1() {
        Long memberId = 1L;
        Post post = createPost(memberId);
        CreateCodeReviewDto dto = getReqDto();


        createService.write(post, dto);


        assertThat(post.getCodeReview().getMissionId())
                .isEqualTo(1L);
    }



    private CreateCodeReviewDto getReqDto() {
        return new CreateCodeReviewDto(1L, 1L, "", "");
    }


}