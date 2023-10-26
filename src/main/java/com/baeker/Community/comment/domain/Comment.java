package com.baeker.Community.comment.domain;

import com.baeker.Community.global.baseEntity.BaseEntity;
import com.baeker.Community.post.domain.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;
import static java.time.LocalDateTime.now;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Comment extends BaseEntity {

    private Long memberId;
    private String content;

    @ManyToOne(fetch = LAZY)
    private Post post;

    public static Comment write(Long memberId, Post post, String content) {
        Comment comment = Comment.builder()
                .memberId(memberId)
                .content(content)
                .post(post)
                .build();

        post.getCommentList().add(comment);
        return comment;
    }

    public Comment modifyContent(String content) {
        return this.toBuilder()
                .modifyDate(now())
                .content(content)
                .build();
    }
}
