package com.baeker.Community.post.application.service.post.create;

import com.baeker.Community.global.dto.reqDto.CreateStudyPostDto;
import com.baeker.Community.post.application.service.post.PostCreateService;
import com.baeker.Community.post.application.service.repositoryMock.PostMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("단위 - 스터디 전용 게시물 생성")
@ExtendWith(MockitoExtension.class)
class PostCreateService_studyPostTest extends PostMock {

    @InjectMocks
    PostCreateService createService;

    @BeforeEach
    void setup() {
        savePostMocking();
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
}