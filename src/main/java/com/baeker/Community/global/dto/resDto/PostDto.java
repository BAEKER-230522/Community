package com.baeker.Community.global.dto.resDto;

import com.baeker.Community.post.domain.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PROTECTED;

@Data
@NoArgsConstructor(access = PROTECTED)
public class PostDto {

    private Long postId;
    private Long memberId;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private int pageView;
    private int follower;
    private String title;
    private String content;
    private List<CommentDto> comments;

    public PostDto(Post post) {
        this.postId = post.getId();
        this.memberId = post.getMemberId();
        this.createDate = post.getCreateDate();
        this.modifyDate = post.getModifyDate();
        this.pageView = post.getPageView();
        this.follower = post.getFollowCount();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.comments = post.getCommentList()
                .stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());
    }
}
