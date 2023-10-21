package com.baeker.Community.post.application.service.modify;

import com.baeker.Community.global.testUtil.CreateObject;
import com.baeker.Community.post.application.service.PostModifyService;
import com.baeker.Community.post.application.service.repository.PostMock;
import com.baeker.Community.post.domain.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게시물 추천 단위 테스트")
@ExtendWith(MockitoExtension.class)
class PostModifyService_followTest extends PostMock {

    @InjectMocks
    PostModifyService modifyService;

    @BeforeEach
    void setup() {
        savePostMocking();
    }

    @Test
    @DisplayName("게시물 추천 성공")
    void no1() {
        Long
                memberId = 1L,
                postId = 1L;
        Post post = CreateObject.createPost(memberId, postId);

        modifyService.follow(memberId, post);

        assertThat(post.getFollowCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("게시물 추천 취소")
    void no2() {
        Long
                memberId = 1L,
                postId = 1L;
        Post post = CreateObject.createPost(memberId, postId);

        modifyService.follow(memberId, post);
        modifyService.follow(memberId, post);

        assertThat(post.getFollowCount()).isEqualTo(0);
    }
}