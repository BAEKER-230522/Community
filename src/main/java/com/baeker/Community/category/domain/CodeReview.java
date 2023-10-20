package com.baeker.Community.category.domain;

import com.baeker.Community.global.baseEntity.BaseCategory;
import com.baeker.Community.post.domain.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class CodeReview extends BaseCategory {

    private Long memberId;
    private Long problemStatusId;

    @ManyToOne(fetch = LAZY)
    private Mission mission;


    public static CodeReview setting(Mission mission, Long problemStatusId) {
        CodeReview codeReview = CodeReview.builder()
                .problemStatusId(problemStatusId)
                .build();

        mission.getCodeReviewList().add(codeReview);
        return codeReview;
    }

    public CodeReview write(Post post) {
        return this.toBuilder()
                .memberId(post.getMemberId())
                .post(post)
                .build();
    }
}
