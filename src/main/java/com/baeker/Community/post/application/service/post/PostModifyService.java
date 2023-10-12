package com.baeker.Community.post.application.service.post;

import com.baeker.Community.member.application.in.member.MemberModifyUseCase;
import com.baeker.Community.member.domain.Member;
import com.baeker.Community.post.application.port.in.post.PostModifyUseCase;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import com.baeker.Community.post.domain.post.Followers;
import com.baeker.Community.post.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostModifyService implements PostModifyUseCase {

    private final MemberModifyUseCase memberModifyUseCase;
    private final PostQueryUseCase postQueryUseCase;
    private final MongoTemplate mongoTemplate;


    @Override
    public void follow(Member member, Long personalId) {
        Post post = postQueryUseCase.byPersonalId(personalId);

        Followers followers = following(member, post);
        mongoTemplate.save(followers);
    }

    private Followers following(Member member, Post post) {
        Followers followers = post.getFollowers();

        if (isFollow(member.getMemberId(), followers))
            unfollow(member, post.getId(), followers);
        else
            doFollow(member, post.getId(), followers);

        return followers;
    }

    private boolean isFollow(Long memberId, Followers followers) {
        for (Long follower : followers.getFollowerList())
            if (follower == memberId) return true;

        return false;
    }

    private void unfollow(Member member, String postId, Followers followers) {
        followers.unfollow(member.getMemberId());
        memberModifyUseCase.unfollow(member, postId);
    }

    private void doFollow(Member member, String postId, Followers followers) {
        followers.following(member.getMemberId());
        memberModifyUseCase.follow(member,postId);
    }
}