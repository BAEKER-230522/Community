package com.baeker.Community.global.dto.mapper;

import com.baeker.Community.global.dto.resDto.ChallengerDto;
import com.baeker.Community.global.dto.resDto.FollowingDto;
import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.member.domain.Following;
import com.baeker.Community.mission.domain.Challenger;
import com.baeker.Community.mission.domain.Mission;
import com.baeker.Community.post.domain.category.CodeReview;
import com.baeker.Community.post.domain.post.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public List<PostDto> toPostDtos(List<Post> postList) {
        return postList.stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }

    public FollowingDto toFollowingDto(Following following) {
        FollowingDto resDto = new FollowingDto();
        resDto.setPosts(toPostDtos(following.getCodeReviewList()));
        return resDto;
    }

    public List<ChallengerDto> toChallengers(Mission mission) {
        List<Challenger> challengerList = mission.getChallengerList();
        return challengerList.stream()
                .map(ChallengerDto::new)
                .collect(Collectors.toList());
    }
}
