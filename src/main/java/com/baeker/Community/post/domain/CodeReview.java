package com.baeker.Community.post.domain;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import jakarta.persistence.DiscriminatorValue;
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
@DiscriminatorValue("C")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class CodeReview extends Post {

    private Long missionId;
    private Long problemStatusId;
    private String language;

    public static CodeReview write(Long memberId, CreateCodeReviewDto dto) {
        return CodeReview.builder()
                .memberId(memberId)
                .missionId(dto.getMissionId())
                .problemStatusId(dto.getProblemStatusId())
                .language(dto.getLanguage())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }
}
