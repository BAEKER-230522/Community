package com.baeker.Community.documentGroup.application.out;

import com.baeker.Community.documentGroup.domain.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemberRepositoryPort extends MongoRepository<Member, String> {

    List<Member> findByMemberId(Long memberId);
}
