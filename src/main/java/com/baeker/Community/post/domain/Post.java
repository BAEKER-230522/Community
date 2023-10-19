package com.baeker.Community.post.domain;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.baseEntity.BaseComm;
import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Post extends BaseComm {

    private Long memberId;
    private String title;
    private String content;
    private int pageView;

    @Builder.Default
    @ElementCollection
    private List<Long> followList = new ArrayList<>();

    @OneToMany(cascade = ALL)
    @Builder.Default
    private List<Comment> commentList = new ArrayList<>();

    public static Post write(Long memberId, CreateCodeReviewDto dto) {
        return Post.builder()
                .memberId(memberId)
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }

    public void follow(Long memberId) {
        if (this.followList.contains(memberId))
            unfollow(memberId);
        else
            doFollow(memberId);
    }

    private void doFollow(Long memberId) {
        this.followList
                .add(memberId);
    }

    private void unfollow(Long memberId) {
        this.followList
                .remove(memberId);
    }


    public int getFollowCount() {
        return this.followList
                .size();
    }
}
