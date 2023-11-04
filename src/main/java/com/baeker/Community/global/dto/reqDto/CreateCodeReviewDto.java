package com.baeker.Community.global.dto.reqDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCodeReviewDto {

    private Long studyId;
    private Long missionId;
    private Long problemStatusId;
    private String language;
    private String title;
    private String content;
}
