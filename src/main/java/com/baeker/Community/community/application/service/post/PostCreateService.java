package com.baeker.Community.community.application.service.post;

import com.baeker.Community.community.adapter.in.reqDto.CreatePostDto;
import com.baeker.Community.community.adapter.in.resDto.PostResDto;
import com.baeker.Community.community.application.port.in.pageView.PageViewUserCase;
import com.baeker.Community.community.application.port.in.post.PostCreateUseCase;
import com.baeker.Community.community.application.port.out.PostRepositoryPort;
import com.baeker.Community.community.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostCreateService implements PostCreateUseCase {

    private final PostRepositoryPort repository;
    private final PageViewUserCase pageViewUserCase;

    @Override
    public PostResDto post(Long memberId, CreatePostDto dto) {
        dto.setPageView(pageViewUserCase.create());

        Post post = repository.save(
                Post.create(memberId, dto));
        return new PostResDto(post);
    }
}
