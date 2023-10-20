package com.baeker.Community.category.domain;

import com.baeker.Community.global.baseEntity.BaseEntity;
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
public class Mission extends BaseEntity {

    private Long missionId;

    @Builder.Default
    @OneToMany(mappedBy = "mission", cascade = ALL)
    private List<CodeReview> codeReviewList = new ArrayList<>();


    public static Mission setting(Long missionId) {
        return Mission.builder()
                .missionId(missionId)
                .build();
    }
}
