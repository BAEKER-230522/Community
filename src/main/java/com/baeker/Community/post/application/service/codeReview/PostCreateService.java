package com.baeker.Community.post.application.service.codeReview;

import com.baeker.Community.post.application.port.in.PostCreateUseCase;
import com.baeker.Community.post.application.port.out.PostRepositoryPort;
import com.baeker.Community.post.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostCreateService implements PostCreateUseCase {

    private final PostRepositoryPort repository;

    @Override
    public Post setting(Long problemStatusId) {
        return repository.save(
                Post.settingMission(problemStatusId)
        );
    }
}
