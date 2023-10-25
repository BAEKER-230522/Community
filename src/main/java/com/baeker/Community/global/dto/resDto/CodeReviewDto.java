package com.baeker.Community.global.dto.resDto;

import com.baeker.Community.post.domain.CodeReview;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Data
@NoArgsConstructor(access = PROTECTED)
public class CodeReviewDto {

    private Long id;
    private Long memberId;
    private Long missionId;
    private Long problemStatusId;
    private LocalDateTime createDate;
    private int pageView;
    private int follower;
    private String title;
    private String content;
//    private List<Comment> comments;

    public CodeReviewDto(Long postId, CodeReview codeReview) {
        this.id = postId;
        this.memberId = codeReview.getMemberId();
        this.missionId = codeReview.getMissionId();
        this.problemStatusId = codeReview.getProblemStatusId();
        this.createDate = codeReview.getCreateDate();
        this.pageView = codeReview.getPageView();
        this.follower = codeReview.getFollowCount();
        this.title = codeReview.getTitle();
        this.content = codeReview.getContent();
//        this.comments = codeReview.getCommentList();
    }

    public CodeReviewDto(CodeReview codeReview) {
        this.id = codeReview.getId();
        this.memberId = codeReview.getMemberId();
        this.missionId = codeReview.getMissionId();
        this.problemStatusId = codeReview.getProblemStatusId();
        this.createDate = codeReview.getCreateDate();
        this.pageView = codeReview.getPageView();
        this.follower = codeReview.getFollowCount();
        this.title = codeReview.getTitle();
        this.content = codeReview.getContent();
//        this.comments = codeReview.getCommentList();
    }
}
