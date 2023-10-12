package com.baeker.Community.member.application.service.member;

import com.baeker.Community.member.application.in.member.MemberModifyUseCase;
import com.baeker.Community.member.application.in.member.MemberQueryUseCase;
import com.baeker.Community.member.application.out.MemberRepositoryPort;
import com.baeker.Community.member.domain.Member;
import com.baeker.Community.member.domain.embedded.Posting;
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
    public void posting(Long memberId, Posting posting) {
        Member member = memberQueryUseCase.byMemberId(memberId);
        member.writePost(posting);
        repository.save(member);
    }

    @Override
    public void follow(Member member, String postId) {
        member.followContent(postId);
        repository.save(member);
    }

    @Override
    public void unfollow(Member member, String postId) {
        member.unfollow(postId);
        repository.save(member);
    }
}
