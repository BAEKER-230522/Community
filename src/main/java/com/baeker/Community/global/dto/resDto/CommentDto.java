package com.baeker.Community.global.dto.resDto;

import com.baeker.Community.comment.domain.Comment;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CommentDto {

    private Long commentId;
    private Long postId;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private String content;

    public CommentDto(Comment comment) {
        this.commentId = comment.getId();
        this.postId = comment.getPost().getId();
        this.createDate = comment.getCreateDate();
        this.modifyDate = comment.getModifyDate();
        this.content = comment.getContent();
    }

    @QueryProjection
    public CommentDto(Long commentId, Long postId, LocalDateTime createDate, LocalDateTime modifyDate, String content) {
        this.commentId = commentId;
        this.postId = postId;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.content = content;
    }
}
