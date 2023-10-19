package com.baeker.Community.comment.domain;

import com.baeker.Community.post.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Document
@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Comment {

    @Id
    private String id;
    private Long memberId;
    private LocalDateTime createDate;
    private String comment;

    @DBRef
    private Post post;

    public static Comment create(Long memberId, Post post, String comment) {
        return Comment.builder()
                .memberId(memberId)
                .createDate(LocalDateTime.now())
                .comment(comment)
                .post(post)
                .build();
    }
}
