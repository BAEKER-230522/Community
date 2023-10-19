package com.baeker.Community.category.domain;

import com.baeker.Community.global.baseEntity.BaseCategory;
import com.baeker.Community.post.domain.Post;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class CodeReview extends BaseCategory {

    private Long missionId;
    private Long problemStatusId;

    public static CodeReview setting(Long missionId, Long problemStatusId) {
        return CodeReview.builder()
                .missionId(missionId)
                .problemStatusId(problemStatusId)
                .build();
    }

    public CodeReview write(Post post) {
        return this.toBuilder()
                .post(post)
                .build();
    }
}
