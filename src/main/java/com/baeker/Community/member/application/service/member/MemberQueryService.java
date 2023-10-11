package com.baeker.Community.member.application.service.member;

import com.baeker.Community.member.application.in.member.MemberQueryUseCase;
import com.baeker.Community.member.application.out.MemberRepositoryPort;
import com.baeker.Community.member.domain.Member;
import com.baeker.Community.global.exception.service.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryService implements MemberQueryUseCase {

    private final MemberRepositoryPort repository;

    @Override
    public Member byMemberId(Long memberId) {
        List<Member> members = repository.findByMemberId(memberId);

        if (members.size() == 0)
            throw new NotFoundException("데이터가 존재하지 않습니다.");

        return members.get(0);
    }
}
