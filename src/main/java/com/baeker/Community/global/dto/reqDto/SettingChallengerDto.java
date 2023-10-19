package com.baeker.Community.global.dto.reqDto;

import lombok.Data;

import java.util.List;

@Data
public class SettingChallengerDto {

    private Long memberId;
    private List<Long> problemStatusIdList;
}
