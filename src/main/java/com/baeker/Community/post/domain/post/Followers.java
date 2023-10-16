package com.baeker.Community.post.domain.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Followers {

    @Builder.Default
    private List<Long> memberList = new ArrayList<>();

    public static Followers create() {
        return Followers.builder().build();
    }

    public void following(Long memberId) {
        this.memberList.add(memberId);
    }

    public void unfollow(Long memberId) {
        this.memberList.remove(memberId);
    }
}
