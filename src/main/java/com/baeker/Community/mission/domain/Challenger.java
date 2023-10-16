package com.baeker.Community.mission.domain;

import com.baeker.Community.post.domain.category.CodeReview;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Challenger {

    private Long memberId;

    @Field
    @Builder.Default
    private List<CodeReview> codeReviewList = new ArrayList<>();

    public static Challenger create(Long memberId, List<Long> problemStatusIdList) {
        Challenger challenger = Challenger.builder()
                .memberId(memberId)
                .build();

        for (Long problemStatusId : problemStatusIdList)
            challenger.codeReviewList.add(CodeReview.setting(problemStatusId));

        return challenger;
    }

    public CodeReview getCodeReview(Long problemStatusId) {
        for (CodeReview codeReview : this.codeReviewList)
            if (codeReview.getProblemStatusId() == problemStatusId)
                return codeReview;

        return null;
    }
}
