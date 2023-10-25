package com.baeker.Community.global.dto.reqDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifyPostDto {

    private Long postId;
    private String title;
    private String content;
}
