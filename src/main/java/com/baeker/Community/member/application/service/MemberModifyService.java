package com.baeker.Community.member.application.service;

import com.baeker.Community.member.application.in.MemberModifyUseCase;
import com.baeker.Community.member.application.in.MemberQueryUseCase;
import com.baeker.Community.member.application.out.MemberRepositoryPort;
import com.baeker.Community.member.domain.Member;
import com.baeker.Community.post.domain.category.CodeReview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberModifyService implements MemberModifyUseCase {

    private final MemberRepositoryPort repository;
    private final MemberQueryUseCase memberQueryUseCase;

    @Override
    public void posting(Long memberId, CodeReview codeReview) {
        Member member = memberQueryUseCase.byMemberId(memberId);
        member.writePost(codeReview);
        repository.save(member);
    }

    @Override
    public void follow(Member member, String codeReviewId) {
        member.followContent(codeReviewId);
        repository.save(member);
    }

    @Override
    public void unfollow(Member member, String codeReviewId) {
        member.unfollow(codeReviewId);
        repository.save(member);
    }
}
