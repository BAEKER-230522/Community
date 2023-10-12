package com.baeker.Community.member.domain;

import com.baeker.Community.member.domain.embedded.Posting;
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

    @Field("postings")
    @Builder.Default
    private List<Posting> postings = new ArrayList<>();

    @Field("following")
    @Builder.Default
    private List<String> following = new ArrayList<>();


    public static Member create(Long memberId) {
        return Member.builder()
                .memberId(memberId)
                .build();
    }

    public void writePost(Posting posting) {
        this.postings.add(posting);
    }

    public void followContent(String postId) {
        this.following.add(postId);
    }

    public void unfollow(String postId) {
        this.following.remove(postId);
    }
}
