package com.baeker.Community.post.domain.post;

import com.baeker.Community.comment.domain.Comments;
import com.baeker.Community.global.dto.reqDto.CreatePostDto;
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
public class Post {

    @Id
    private String id;
    private Long memberId;
    private Long personalId;
    private LocalDateTime createDate;

    private Category category;

    @DBRef
    private Content content;

    @DBRef
    private Comments comments;

    @DBRef
    private PageView pageView;

    @DBRef
    private Followers followers;


    public static Post create(Long memberId, CreatePostDto dto) {
        return Post.builder()
                .memberId(memberId)
                .createDate(LocalDateTime.now())
                .category(dto.getCategory())
                .content(dto.getContent())
                .comments(dto.getComments())
                .pageView(dto.getPageView())
                .followers(dto.getFollowers())
                .build();
    }

    public static Post createMission(Long memberId, CreatePostDto dto) {
        Post post = create(memberId, dto);
        post.personalId = dto.getPersonalId();
        return post;
    }
}
