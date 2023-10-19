package com.baeker.Community.global.dto.mapper;

import com.baeker.Community.global.dto.resDto.ChallengerDto;
import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.category.domain.Mission;
import com.baeker.Community.post.domain.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public List<PostDto> toPostDtos(List<Post> postList) {
        return postList.stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }

    public List<ChallengerDto> toChallengers(Mission mission) {
        List<Challenger> challengerList = mission.getChallengerList();
        return challengerList.stream()
                .map(ChallengerDto::new)
                .collect(Collectors.toList());
    }
}
