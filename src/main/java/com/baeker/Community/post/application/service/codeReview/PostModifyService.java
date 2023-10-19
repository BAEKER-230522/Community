package com.baeker.Community.post.application.service.codeReview;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.member.application.in.MemberModifyUseCase;
import com.baeker.Community.member.domain.Member;
import com.baeker.Community.post.application.port.in.PostModifyUseCase;
import com.baeker.Community.post.application.port.out.PostRepositoryPort;
import com.baeker.Community.post.domain.post.Followers;
import com.baeker.Community.post.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostModifyService implements PostModifyUseCase {

    private final MemberModifyUseCase memberModifyUseCase;
    private final PostRepositoryPort repository;


    @Override
    public CodeReviewDto write(Long memberId, CreateCodeReviewDto dto, Post post) {
        Post updatePost = repository.save(
                post.write(memberId, dto)
        );
        return new CodeReviewDto(updatePost);
    }

    @Override
    public void follow(Member member, Post post) {
        Followers followers = following(member, post);
        post.modifyFollow(followers); // 변수 최신화 안해도 됨?
        repository.save(post);
    }

    @Override
    public void addComment(Post post, Comment comment) {
        post.addComment(comment);
        repository.save(post);
    }



    private Followers following(Member member, Post post) {
        Followers followers = post.getFollowers();

        if (isFollow(member.getMemberId(), followers))
            unfollow(member, post, followers);
        else
            doFollow(member, post, followers);

        return followers;
    }

    private boolean isFollow(Long memberId, Followers followers) {
        for (Long follower : followers.getMemberList())
            if (follower == memberId)
                return true;

        return false;
    }

    private void unfollow(Member member, Post post, Followers followers) {
        followers.unfollow(member.getMemberId());
        memberModifyUseCase.unfollow(member, post);
    }

    private void doFollow(Member member, Post post, Followers followers) {
        followers.following(member.getMemberId());
        memberModifyUseCase.follow(member,post);
    }
}