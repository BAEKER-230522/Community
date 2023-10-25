package com.baeker.Community.global.dto.resDto;

import com.baeker.Community.post.domain.Post;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Data
@NoArgsConstructor(access = PROTECTED)
public class PostDto {

    private Long id;
    private Long memberId;
    private LocalDateTime createDate;
    private int pageView;
    private int follower;
    private String title;
    private String content;

    public PostDto(Post post) {
        this.id = post.getId();
        this.memberId = post.getMemberId();
        this.createDate = post.getCreateDate();
        this.pageView = post.getPageView();
        this.follower = post.getFollowCount();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
