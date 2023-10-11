package com.baeker.Community.member.application.service.member;

import com.baeker.Community.member.application.in.member.MemberCreateUseCase;
import com.baeker.Community.member.application.out.MemberRepositoryPort;
import com.baeker.Community.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberCreateService implements MemberCreateUseCase {

    private final MemberRepositoryPort repository;

    @Override
    public Member setting(Long memberId) {
        return repository.save(
                Member.create(memberId)
        );
    }
}
