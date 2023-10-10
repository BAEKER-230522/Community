package com.baeker.Community.documentGroup.application.service.member;

import com.baeker.Community.documentGroup.application.in.member.MemberQueryUseCase;
import com.baeker.Community.documentGroup.domain.Member;
import com.baeker.Community.global.exception.service.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryService implements MemberQueryUseCase {

    private final MongoTemplate repository;

    @Override
    public Member byMemberId(Long memberId) {
        Criteria criteria = Criteria.where("memberId").is(memberId);
        Query query = new Query(criteria);

        List<Member> members = repository.find(query, Member.class);

        if (members.size() == 0)
            throw new NotFoundException("데이터가 존재하지 않습니다.");

        return members.get(0);
    }
}
