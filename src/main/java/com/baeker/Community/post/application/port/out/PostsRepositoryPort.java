package com.baeker.Community.post.application.port.out;

import com.baeker.Community.member.domain.embedded.Posting;
import com.baeker.Community.post.domain.posts.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostsRepositoryPort extends MongoRepository<Posts, String> {

    List<Posts> findByMissionId(Long missionId);
}
