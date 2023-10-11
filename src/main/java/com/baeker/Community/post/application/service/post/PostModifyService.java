package com.baeker.Community.post.application.service.post;

import com.baeker.Community.post.application.port.in.post.PostModifyUseCase;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import com.baeker.Community.post.domain.post.Followers;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostModifyService implements PostModifyUseCase {

    private final PostQueryUseCase postQueryUseCase;
    private final MongoTemplate mongoTemplate;


    @Override
    public void follow(Long memberId, Long personalId) {
        Followers followers = postQueryUseCase.byPersonalId(personalId).getFollowers();
        following(followers, memberId);
        mongoTemplate.save(followers);
    }

    private void following(Followers followers, Long memberId) {
        for (Long follower : followers.getFollowerList())

            if (follower == memberId) {
                followers.unfollow(memberId);
                return;
            }
        followers.following(memberId);
    }
}
