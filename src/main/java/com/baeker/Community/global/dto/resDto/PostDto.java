package com.baeker.Community.global.dto.resDto;

import com.baeker.Community.post.domain.category.CodeReview;
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

    public PostDto(CodeReview codeReview) {
        this.category = "CODE REVIEW";
        this.createDate = codeReview.getPost().getCreateDate();
        this.title = codeReview.getTitle();
        this.pageView = codeReview.getPageViews();
        this.followers = codeReview.getFollowerCount();
        this.comments = codeReview.getCommentCount();
    }
}
