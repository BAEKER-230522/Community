package com.baeker.Community.documentGroup.application.service.member;

import com.baeker.Community.documentGroup.application.in.member.MemberCreateUseCase;
import com.baeker.Community.documentGroup.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberCreateService implements MemberCreateUseCase {

    private final MongoTemplate repository;

    @Override
    public Member setting(Long memberId) {
        return repository.save(
                Member.create(memberId)
        );
    }
}
