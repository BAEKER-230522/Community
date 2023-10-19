package com.baeker.Community.global.dto.mapper;

import com.baeker.Community.global.dto.resDto.FollowingDto;
import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.member.domain.Following;
import com.baeker.Community.post.domain.category.CodeReview;
import com.baeker.Community.post.domain.post.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public List<PostDto> toPostDtos(List<Post> postList) {
        return postList.stream()
                .map(post -> new PostDto(post))
                .collect(Collectors.toList());
    }

    public FollowingDto toFollowingDto(Following following) {
        FollowingDto resDto = new FollowingDto();
        resDto.setPosts(toPostDtos(following.getCodeReviewList()));
        return resDto;
    }
}
