package com.baeker.Community.global.dto.reqDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifyCommentDto {

    private Long commentId;
    private String content;
}
