package com.baeker.Community.global.dto.reqDto;

import lombok.Data;

@Data
public class CreateCodeReviewDto {

    private Long problemStatusId;
    private String title;
    private String content;
}
