package com.baeker.Community.global.dto.mapper;

import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.post.domain.category.CodeReview;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public List<PostDto> toPostDtos(List<CodeReview> codeReviewList) {
        return codeReviewList.stream()
                .map(codeReview -> new PostDto(codeReview))
                .collect(Collectors.toList());
    }
}
