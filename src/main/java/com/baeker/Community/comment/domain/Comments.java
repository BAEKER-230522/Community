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
    private List<Long> comments;

    public static Comments create() {
        Comments comments = new Comments();
        List<Long> commentList = comments.getComments();
        commentList = new ArrayList<>();
        return comments;
    }

    public void writeComment(Long id) {
        this.comments.add(id);
    }
}
