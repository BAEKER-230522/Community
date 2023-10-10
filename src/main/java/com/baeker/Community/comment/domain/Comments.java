package com.baeker.Community.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Document
@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Comments {

    @Id
    private String id;

    @Builder.Default
    private List<String> comments = new ArrayList<>();

    public static Comments create() {
        return new Comments();
    }

    public void writeComment(String commentId) {
        this.comments.add(commentId);
    }
}
