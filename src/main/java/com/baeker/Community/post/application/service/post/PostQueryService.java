package com.baeker.Community.post.application.service.post;

import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import com.baeker.Community.post.application.port.out.PostRepositoryPort;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostQueryService implements PostQueryUseCase {

    private final PostRepositoryPort repository;


    @Override
    public Post byId(Long postId) {
        Optional<Post> byId = repository.findById(postId);

        if (byId.isPresent())
            return byId.get();

        throw new NotFoundException("존재하지 않는 게시물");
    }
}
