package com.baeker.Community.global.dto.reqDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostsReqDto {

    private Long missionId;
    private List<Long> memberIdList;
    private List<String> titleList;
}
