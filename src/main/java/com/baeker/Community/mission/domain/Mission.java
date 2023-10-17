package com.baeker.Community.mission.domain;

import com.baeker.Community.global.dto.reqDto.SettingMissionDto;
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


    public static Mission setting(SettingMissionDto dto, List<Challenger> challengerList) {
        return Mission.builder()
                .missionId(dto.getMissionId())
                .challengerList(challengerList)
                .build();
    }
}
