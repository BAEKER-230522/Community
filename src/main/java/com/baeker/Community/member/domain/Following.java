package com.baeker.Community.member.domain;

import com.baeker.Community.post.domain.category.CodeReview;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Following {

    @DBRef
    @Builder.Default
    private List<CodeReview> codeReviewList = new ArrayList<>();

    protected void follow(CodeReview codeReview) {
        this.codeReviewList.add(codeReview);
    }

    protected void unfollow(CodeReview codeReview) {
        this.codeReviewList.remove(codeReview);
    }
}
