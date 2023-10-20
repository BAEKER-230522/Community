package com.baeker.Community.global.dto.resDto;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.post.domain.Post;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Data
@NoArgsConstructor(access = PROTECTED)
public class CodeReviewDto {

    private Long id;
    private Long memberId;
    private Long problemStatusId;
    private LocalDateTime createDate;
    private int pageView;
    private int follower;
    private String title;
    private String content;
    private List<Comment> comments;

    public CodeReviewDto(Post post, Long problemStatusId) {
        this.id = post.getId();
        this.memberId = post.getMemberId();
        this.problemStatusId = problemStatusId;
        this.createDate = post.getCreateDate();
        this.pageView = post.getPageView();
        this.follower = post.getFollowCount();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.comments = post.getCommentList();
    }

    @QueryProjection
    public CodeReviewDto(Long id, Long memberId, Long problemStatusId, LocalDateTime createDate, int pageView, int follower, String title, String content, List<Comment> comments) {
        this.id = id;
        this.memberId = memberId;
        this.problemStatusId = problemStatusId;
        this.createDate = createDate;
        this.pageView = pageView;
        this.follower = follower;
        this.title = title;
        this.content = content;
        this.comments = comments;
    }

    @QueryProjection
    public CodeReviewDto(Long problemStatusId) {
        this.problemStatusId = problemStatusId;
    }
}
