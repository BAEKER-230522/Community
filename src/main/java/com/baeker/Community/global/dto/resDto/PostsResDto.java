package com.baeker.Community.global.dto.resDto;

import com.baeker.Community.post.domain.posts.PersonalPosts;
import com.baeker.Community.post.domain.posts.Posts;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PostsResDto {

    private String id;
    private Long missionId;
    private List<PersonalPosts> personalPosts;

    public PostsResDto(Posts posts) {
        this.id = posts.getId();
        this.missionId = posts.getMissionId();
        this.personalPosts = posts.getPostings()
                .values()
                .stream()
                .collect(Collectors.toList());
    }
}
