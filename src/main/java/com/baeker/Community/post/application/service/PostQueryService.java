package com.baeker.Community.post.application.service;

import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.post.application.port.in.PostQueryUseCase;
import com.baeker.Community.post.application.port.out.PostRepositoryPort;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostQueryService implements PostQueryUseCase {

    private final PostRepositoryPort repository;


    @Override
    public Post byId(String postId) {
        Optional<Post> byId = repository.findById(postId);

        if (byId.isPresent())
            return byId.get();

        throw new NotFoundException("존재하지 않는 게시물");
    }

    @Override
    public List<PostDto> byMemberId(Long memberId) {
        List<Post> postList = repository.findByMemberId(memberId);
        return postList.stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }
}
