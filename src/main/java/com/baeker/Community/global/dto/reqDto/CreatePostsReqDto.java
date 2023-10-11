package com.baeker.Community.global.dto.reqDto;

import lombok.Data;

import java.util.List;

@Data
public class CreatePostsReqDto {

    private Long missionId;
    private List<Long> memberIdList;
    private List<String> titleList;
}
