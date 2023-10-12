package com.baeker.Community.member.application.service.member;

import com.baeker.Community.member.application.in.member.MemberCreateUseCase;
import com.baeker.Community.member.application.in.member.MemberQueryUseCase;
import com.baeker.Community.member.application.out.MemberRepositoryPort;
import com.baeker.Community.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryService implements MemberQueryUseCase {

    private final MemberCreateUseCase memberCreateUseCase;
    private final MemberRepositoryPort repository;

    @Override
    public Member byMemberId(Long memberId) {
        List<Member> members = repository.findByMemberId(memberId);

        if (members.size() == 0)
            return memberCreateUseCase.setting(memberId);

        return members.get(0);
    }
}
