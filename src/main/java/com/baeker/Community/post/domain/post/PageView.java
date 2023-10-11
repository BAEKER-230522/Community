package com.baeker.Community.post.domain.post;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Document
@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class PageView {

    @Id
    private String id;
    private int count;

    public static PageView create() {
        return PageView.builder()
                .count(1)
                .build();
    }
}
