package com.baeker.Community.global.dto.resDto;

import com.baeker.Community.post.domain.StudyPost;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PROTECTED;

@Data
@NoArgsConstructor(access = PROTECTED)
public class StudyPostDto {

    private Long postId;
    private Long studyId;
    private Long memberId;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private int pageView;
    private int follower;
    private String title;
    private String content;
    private List<CommentDto> comments;

    public StudyPostDto(StudyPost studyPost) {
        this.postId = studyPost.getId();
        this.studyId = studyPost.getStudyId();
        this.memberId = studyPost.getMemberId();
        this.createDate = studyPost.getCreateDate();
        this.modifyDate = studyPost.getModifyDate();
        this.pageView = studyPost.getPageView();
        this.follower = studyPost.getFollowCount();
        this.title = studyPost.getTitle();
        this.content = studyPost.getContent();
        this.comments = studyPost.getCommentList()
                .stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());
    }
}
