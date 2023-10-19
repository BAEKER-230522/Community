package com.baeker.Community.post.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

//@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Post {

    private String id;
    private Long memberId;
    private Long problemStatusId;
    private LocalDateTime createDate;
    private Category category;
    private String title;
    private String content;

//    private PageView pageView;
//    private Followers followers;
//
//    @Builder.Default
//    private List<Comment> commentList = new ArrayList<>();

}
