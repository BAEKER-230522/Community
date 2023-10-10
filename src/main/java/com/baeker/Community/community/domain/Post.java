package com.baeker.Community.community.domain;

import com.baeker.Community.community.adapter.in.reqDto.CreatePostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Document
@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Post {

    @Id
    private String id;
    private Long memberId;

    @DBRef
    private PageView pageView;

    public static Post create(Long memberId, CreatePostDto dto) {
        return Post.builder()
                .memberId(memberId)
                .pageView(dto.getPageView())
                .build();
    }
}
