package com.baeker.Community.mission.domain;

import com.baeker.Community.global.dto.reqDto.CreatePostsReqDto;
import com.baeker.Community.post.domain.category.CodeReview;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Document
@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Mission {

    @Id
    private String id;
    private Long missionId;

    @Field
    @Builder.Default
    private List<Challenger> challengerList = new ArrayList<>();


    public static Mission setting(CreatePostsReqDto dto) {
        Mission mission = Mission.builder()
                .missionId(dto.getMissionId())
                .build();

        for (Long memberId : dto.getMemberIdList())
            mission.challengerList.add(
                    Challenger.create(
                            memberId,
                            dto.getProblemStatusIdList()
                    ));

        return mission;
    }

    public CodeReview getCodeReview(Long memberId, Long problemStatusId) {
        for (Challenger challenger : this.challengerList)
            if (challenger.getMemberId() == memberId)
                return challenger.getCodeReview(problemStatusId);

        return null;
    }
}
