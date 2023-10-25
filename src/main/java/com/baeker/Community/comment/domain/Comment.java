package com.baeker.Community.comment.domain;

import com.baeker.Community.global.baseEntity.BaseComm;
import com.baeker.Community.global.dto.reqDto.CreateCommentDto;
import com.baeker.Community.post.domain.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Comment extends BaseComm {

    private Long memberId;
    private String content;

    @ManyToOne(fetch = LAZY)
    private Post post;

    public static Comment write(Long memberId, Post post, CreateCommentDto dto) {
        Comment comment = Comment.builder()
                .memberId(memberId)
                .content(dto.getContent())
                .post(post)
                .build();

        post.getCommentList().add(comment);
        return comment;
    }

}
