package com.baeker.Community.global.dto.resDto;

import com.baeker.Community.post.domain.Post;
import lombok.Data;

import java.util.List;

@Data
public class FollowerDto {

    private int count;
    private List<Long> followerList;

    public FollowerDto(Post post) {
        List<Long> followers = post.getFollows();
        this.count = followers.size();
        this.followerList = followers;
    }
}
