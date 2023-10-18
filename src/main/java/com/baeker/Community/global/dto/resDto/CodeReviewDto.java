package com.baeker.Community.global.dto.resDto;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.post.domain.category.CodeReview;
import com.baeker.Community.post.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class CodeReviewDto {

    private String id;
    private Long memberId;
    private Long problemStatusId;
    private LocalDateTime createDate;
    private int pageView;
    private int follower;
    private String title;
    private String content;
    private List<Comment> comments;

    public CodeReviewDto(CodeReview codeReview) {
        Post post = codeReview.getPost();

        this.id = codeReview.getId();
        this.memberId = post.getMemberId();
        this.problemStatusId = codeReview.getProblemStatusId();
        this.createDate = post.getCreateDate();
        this.pageView = post.getPageView().getCount();
        this.follower = post.getFollowers().getMemberList().size();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.comments = post.getCommentList();
    }
}
