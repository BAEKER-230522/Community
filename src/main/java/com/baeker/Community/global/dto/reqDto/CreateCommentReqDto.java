package com.baeker.Community.global.dto.reqDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCommentReqDto {

    private String postId;
    private String comment;
}
