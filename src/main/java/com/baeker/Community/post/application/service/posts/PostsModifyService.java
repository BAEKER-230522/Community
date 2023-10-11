package com.baeker.Community.post.application.service.posts;

import com.baeker.Community.member.domain.embedded.Posting;
import com.baeker.Community.post.application.port.in.posts.PostsModifyUseCase;
import com.baeker.Community.post.application.port.in.posts.PostsQueryUseCase;
import com.baeker.Community.post.application.port.out.PostsRepositoryPort;
import com.baeker.Community.post.domain.posts.Posts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostsModifyService implements PostsModifyUseCase {

    private final PostsRepositoryPort repository;
    private final PostsQueryUseCase postsQueryUseCase;


    @Override
    public void posting(Long memberId, Long missionId, Posting posting) {
        Posts posts = postsQueryUseCase.byMissionId(missionId);
        posts.writePost(memberId, posting);

        repository.save(posts);
    }
}
