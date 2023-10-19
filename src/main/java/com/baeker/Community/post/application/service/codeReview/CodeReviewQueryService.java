package com.baeker.Community.post.application.service.codeReview;

import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.post.application.port.in.PostQueryUseCase;
import com.baeker.Community.post.application.port.out.PostRepositoryPort;
import com.baeker.Community.post.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CodeReviewQueryService implements PostQueryUseCase {

    private final PostRepositoryPort repository;


    @Override
    public Post byId(String postId) {
        Optional<Post> byId = repository.findById(postId);

        if (byId.isPresent())
            return byId.get();

        throw new NotFoundException("존재하지 않는 게시물");
    }

    @Override
    public Post byProblemStatusId(Long problemStatusId) {
        Optional<Post> byProblemStatusId = repository.findByProblemStatusId(problemStatusId);

        if (byProblemStatusId.isPresent())
            return byProblemStatusId.get();

        throw new NotFoundException("존재하지 않는 게시물");
    }
}
