package com.baeker.Community.global.dto.reqDto;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class CreatePostDto {

    private Long missionId;
    private Long problemStatusId;
    private String content;

    @Null @Hidden
    private String title;
}
