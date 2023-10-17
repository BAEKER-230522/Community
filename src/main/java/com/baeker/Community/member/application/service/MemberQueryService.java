package com.baeker.Community.member.application.service;

import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.member.application.in.MemberCreateUseCase;
import com.baeker.Community.member.application.in.MemberQueryUseCase;
import com.baeker.Community.member.application.out.MemberRepositoryPort;
import com.baeker.Community.member.domain.Member;
import com.baeker.Community.post.domain.category.CodeReview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
