package com.baeker.Community.post.domain;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.baseEntity.BaseEntity;
import com.baeker.Community.global.dto.reqDto.ModifyPostDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
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
public abstract class Post extends BaseEntity {

    private Long memberId;
    private String title;
    private int pageView;

    @Column(length = 50000)
    private String content;

    @Builder.Default
    @ElementCollection(fetch = LAZY)
    private List<Long> follows = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "post", cascade = ALL)
    private List<Comment> commentList = new ArrayList<>();



    public Post modifyContent(ModifyPostDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.updateModifyDate();
        return this;
    }

    public void follow(Long memberId) {
        if (this.follows.contains(memberId))
            unfollow(memberId);
        else
            doFollow(memberId);
    }

    public void addPageView() {
        this.pageView++;
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

    public void deleteComment(Comment comment) {
        this.getCommentList()
                .remove(comment);
    }
}