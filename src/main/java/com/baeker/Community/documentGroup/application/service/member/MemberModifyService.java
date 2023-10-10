package com.baeker.Community.documentGroup.application.service.member;

import com.baeker.Community.documentGroup.application.in.member.MemberCreateUseCase;
import com.baeker.Community.documentGroup.application.in.member.MemberModifyUseCase;
import com.baeker.Community.documentGroup.application.in.member.MemberQueryUseCase;
import com.baeker.Community.documentGroup.application.out.MemberRepositoryPort;
import com.baeker.Community.documentGroup.domain.Member;
import com.baeker.Community.documentGroup.domain.embedded.Posting;
import com.baeker.Community.global.exception.service.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberModifyService implements MemberModifyUseCase {

    private final MemberRepositoryPort repository;
    private final MemberCreateUseCase memberCreateUseCase;
    private final MemberQueryUseCase memberQueryUseCase;

    @Override
    public void posting(Long memberId, Posting posting) {
        Member member = getMember(memberId);
        member.writePost(posting);
        repository.save(member);
    }

    private Member getMember(Long memberId) {
        try {
            return memberQueryUseCase.byMemberId(memberId);
        } catch (NotFoundException e) {
            return memberCreateUseCase.setting(memberId);
        }
    }
}
