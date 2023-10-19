package com.baeker.Community.mission.domain;

import com.baeker.Community.global.dto.reqDto.SettingChallengerDto;
import com.baeker.Community.post.domain.category.CodeReview;
import com.baeker.Community.post.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
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

    @DBRef
    @Builder.Default
    private List<Post> codeReviewList = new ArrayList<>();

    public static Challenger create(Long memberId) {
       return Challenger.builder()
                .memberId(memberId)
                .build();
    }
}
