package com.baeker.Community.post.domain;

import com.baeker.Community.global.baseEntity.BaseComm;
import com.baeker.Community.global.dto.reqDto.ModifyPostDto;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.InheritanceType.SINGLE_TABLE;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@Inheritance(strategy = SINGLE_TABLE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public abstract class Post extends BaseComm {

    private Long memberId;
    private String title;
    private String content;
    private int pageView;

    @Builder.Default
    @ElementCollection(fetch = LAZY)
    private List<Long> follows = new ArrayList<>();


    public Post modifyContent(ModifyPostDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        return this;
    }

    public void follow(Long memberId) {
        if (this.follows.contains(memberId))
            unfollow(memberId);
        else
            doFollow(memberId);
    }

    private void doFollow(Long memberId) {
        this.follows
                .add(memberId);
    }

    private void unfollow(Long memberId) {
        this.follows
                .remove(memberId);
    }

    public int getFollowCount() {
        return this.follows
                .size();
    }
}
