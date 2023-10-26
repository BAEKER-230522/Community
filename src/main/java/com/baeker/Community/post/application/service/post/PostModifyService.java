package com.baeker.Community.post.application.service.post;

import com.baeker.Community.global.dto.reqDto.ModifyPostDto;
import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.global.exception.service.NoPermissionException;
import com.baeker.Community.post.application.port.in.post.PostModifyUseCase;
import com.baeker.Community.post.application.port.out.PostRepositoryPort;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostModifyService implements PostModifyUseCase {

    private final PostRepositoryPort repository;

    @Override
    public void follow(Long memberId, Post post) {
        post.follow(memberId);
        repository.save(post);
    }

    @Override
    public PostDto post(Long memberId, Post post, ModifyPostDto dto) {
        isWriter(memberId, post);

        Post modifyPost = repository.save(
                post.modifyContent(dto)
        );
        return new PostDto(modifyPost);
    }

    @Override
    public void addPageView(Post post) {
        post.addPageView();
    }

    private void isWriter(Long memberId, Post post) {
        if (post.getMemberId() != memberId)
            throw new NoPermissionException("권한이 없습니다.");
    }
}