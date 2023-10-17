package com.baeker.Community.global.dto.resDto;

import com.baeker.Community.post.domain.category.CodeReview;
import lombok.Data;

import java.util.List;

@Data
public class FollowerDto {

    private int count;
    private List<Long> followerList;

    public FollowerDto(CodeReview codeReview) {
        List<Long> followers = codeReview.getFollowers();
        this.count = followers.size();
        this.followerList = followers;
    }
}
