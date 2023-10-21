package com.baeker.Community.global.dto.reqDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCodeReviewDto {

    private Long missionId;
    private Long problemStatusId;
    private String title;
    private String content;
}
