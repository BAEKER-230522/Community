package com.baeker.Community.post.application.service.post;

import com.baeker.Community.global.exception.service.NoPermissionException;
import com.baeker.Community.post.application.port.in.post.PostDeleteUseCase;
import com.baeker.Community.post.application.port.out.persistence.PostRepositoryPort;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostDeleteService implements PostDeleteUseCase {

    private final PostRepositoryPort repository;


    @Override
    public void post(Long memberId, Post post) {
        isWriter(memberId, post);

        repository.delete(post);
    }


    private void isWriter(Long memberId, Post post) {
        if (post.getMemberId() != memberId)
            throw new NoPermissionException("권한이 없습니다.");
    }
}
