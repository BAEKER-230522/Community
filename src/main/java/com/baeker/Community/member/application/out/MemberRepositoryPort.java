package com.baeker.Community.member.application.out;

import com.baeker.Community.member.domain.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemberRepositoryPort extends MongoRepository<Member, String> {

    List<Member> findByMemberId(Long memberId);
}
