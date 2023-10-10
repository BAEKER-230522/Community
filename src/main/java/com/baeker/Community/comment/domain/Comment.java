package com.baeker.Community.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
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


    public static Comment create(Long memberId, String comment) {
        return Comment.builder()
                .memberId(memberId)
                .comment(comment)
                .build();
    }
}
