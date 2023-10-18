package com.baeker.Community.global.dto.resDto;

import lombok.Data;

import java.util.List;

@Data
public class FollowingDto {

    private List<PostDto> posts;
}
