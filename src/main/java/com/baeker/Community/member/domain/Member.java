package com.baeker.Community.member.domain;

import com.baeker.Community.post.domain.category.CodeReview;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Document
@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Member {

    @Id
    private String id;
    private Long memberId;

    @Field
    @Builder.Default
    private List<CodeReview> codeReviewList = new ArrayList<>();

    @Field
    @Builder.Default
    private List<String> following = new ArrayList<>();


    public static Member create(Long memberId) {
        return Member.builder()
                .memberId(memberId)
                .build();
    }

    public void writePost(CodeReview codeReview) {
        this.codeReviewList.add(codeReview);
    }

    public void followContent(String codeReviewId) {
        this.following.add(codeReviewId);
    }

    public void unfollow(String codeReviewId) {
        this.following.remove(codeReviewId);
    }
}
