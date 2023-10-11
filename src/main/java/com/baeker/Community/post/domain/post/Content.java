package com.baeker.Community.post.domain.post;

import com.baeker.Community.global.dto.reqDto.CreatePostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Document
@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Content {

    @Id
    private String id;
    private String title;
    private String body;


    public static Content create(CreatePostDto dto) {
        return Content.builder()
                .title(dto.getTitle())
                .body(dto.getBody())
                .build();
    }
}
