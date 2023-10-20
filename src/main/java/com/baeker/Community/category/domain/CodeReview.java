package com.baeker.Community.category.domain;

import com.baeker.Community.global.baseEntity.BaseCategory;
import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
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

    private Long missionId;
    private Long memberId;
    private Long problemStatusId;


    public static CodeReview write(Post post, CreateCodeReviewDto dto) {
        CodeReview codeReview = builder()
                .memberId(post.getMemberId())
                .missionId(dto.getMissionId())
                .problemStatusId(dto.getProblemStatusId())
                .post(post)
                .build();

        post.addCodeReview(codeReview);
        return codeReview;
    }
}
