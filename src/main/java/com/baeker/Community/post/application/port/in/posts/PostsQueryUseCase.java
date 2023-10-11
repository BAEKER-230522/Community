package com.baeker.Community.post.application.port.in.posts;

import com.baeker.Community.post.domain.posts.Posts;

public interface PostsQueryUseCase {

    Posts byMissionId(Long missionId);
}
