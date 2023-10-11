package com.baeker.Community.post.application.service.posts;

import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.post.application.port.in.posts.PostsQueryUseCase;
import com.baeker.Community.post.application.port.out.PostsRepositoryPort;
import com.baeker.Community.post.domain.posts.Posts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsQueryService implements PostsQueryUseCase {

    private final PostsRepositoryPort repository;


    @Override
    public Posts byMissionId(Long missionId) {
        List<Posts> postsList = repository.findByMissionId(missionId);

        if (postsList.size() == 0)
            throw new NotFoundException("데이터가 존재하지 않습니다.");

        return postsList.get(0);
    }
}
