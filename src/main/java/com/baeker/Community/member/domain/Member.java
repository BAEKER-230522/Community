package com.baeker.Community.member.domain;

import com.baeker.Community.post.domain.post.Post;
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
    private Following following;

    @Field
    @Builder.Default
    private List<Post> postList = new ArrayList<>();


    public static Member create(Long memberId) {
        return Member.builder()
                .memberId(memberId)
                .build();
    }

    public void writePost(Post post) {
        this.postList.add(post);
    }

    public void followContent(Post post) {
        this.following.follow(post);
    }

    public void unfollow(Post post) {
        this.following.unfollow(post);
    }
}
