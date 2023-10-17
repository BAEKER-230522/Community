package com.baeker.Community.post.application.service;

import com.baeker.Community.member.application.in.MemberModifyUseCase;
import com.baeker.Community.member.domain.Member;
import com.baeker.Community.post.application.port.in.CodeReviewQueryUseCase;
import com.baeker.Community.post.application.port.in.PostModifyUseCase;
import com.baeker.Community.post.application.port.out.CodeReviewRepositoryPort;
import com.baeker.Community.post.domain.category.CodeReview;
import com.baeker.Community.post.domain.post.Followers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostModifyService implements PostModifyUseCase {

    private final MemberModifyUseCase memberModifyUseCase;
    private final CodeReviewQueryUseCase codeReviewQueryUseCase;
    private final CodeReviewRepositoryPort repository;


    @Override
    public void follow(Member member, Long problemStatusId) {
        CodeReview codeReview = codeReviewQueryUseCase.byProblemStatusId(problemStatusId);
        Followers followers = following(member, codeReview);
        codeReview.modifyFollow(followers);
        repository.save(codeReview);
    }

    private Followers following(Member member, CodeReview codeReview) {
        Followers followers = codeReview.getPost().getFollowers();

        if (isFollow(member.getMemberId(), followers))
            unfollow(member, codeReview, followers);
        else
            doFollow(member, codeReview, followers);

        return followers;
    }

    private boolean isFollow(Long memberId, Followers followers) {
        for (Long follower : followers.getMemberList())
            if (follower == memberId)
                return true;

        return false;
    }

    private void unfollow(Member member, CodeReview codeReview, Followers followers) {
        followers.unfollow(member.getMemberId());
        memberModifyUseCase.unfollow(member, codeReview);
    }

    private void doFollow(Member member, CodeReview codeReview, Followers followers) {
        followers.following(member.getMemberId());
        memberModifyUseCase.follow(member,codeReview);
    }
}