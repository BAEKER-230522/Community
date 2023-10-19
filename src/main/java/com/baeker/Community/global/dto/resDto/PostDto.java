package com.baeker.Community.global.dto.resDto;

import com.baeker.Community.post.domain.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {

    private String category;
    private LocalDateTime createDate;
    private String title;
    private int pageView;
    private int followers;
    private int comments;

    public PostDto(Post post) {
        this.category = "CODE_REVIEW";
        this.createDate = post.getCreateDate();
        this.title = post.getTitle();
        this.pageView = post.getPageViewCount();
        this.followers = post.getFollowCount();
        this.comments = post.getCommentCount();
    }
}
