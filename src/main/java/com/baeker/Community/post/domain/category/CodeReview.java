package com.baeker.Community.post.domain.category;

import com.baeker.Community.post.domain.post.PageView;
import com.baeker.Community.post.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class CodeReview {

    private Long memberId;
    private Long problemStatusId;
    private String postId;
    private LocalDateTime createDate;
    private String title;

    @Field
    private PageView pageView;


    public void write(Post post) {
        this.toBuilder()
                .memberId(post.getMemberId())
                .postId(post.getId())
                .createDate(post.getCreateDate())
                .title(post.getTitle())
                .build();
    }

    public static CodeReview setting(Long problemStatusId) {
        return CodeReview.builder()
                .problemStatusId(problemStatusId)
                .build();
    }
}