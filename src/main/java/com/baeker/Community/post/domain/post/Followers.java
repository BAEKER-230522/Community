package com.baeker.Community.post.domain.post;

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
public class Followers {

    @Id
    private String id;
    private List<Long> followerList;

    public static Followers create() {
        Followers follower = new Followers();
        follower.followerList = new ArrayList<>();
        return follower;
    }

    public void following(Long memberId) {
        this.followerList.add(memberId);
    }

    public void unfollow(Long memberId) {
        this.followerList.remove(memberId);
    }
}
