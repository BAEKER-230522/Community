package com.baeker.Community.global.dto.resDto;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.post.domain.Post;
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

    public CodeReviewDto(Post post) {
        this.id = post.getId();
        this.problemStatusId = post.getProblemStatusId();

        if (post.getTitle() != null) toDto(post);
    }

    private void toDto(Post post) {
        this.memberId = post.getMemberId();
        this.createDate = post.getCreateDate();
        this.pageView = post.getPageViewCount();
        this.follower = post.getFollowCount();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.comments = post.getCommentList();
    }
}
