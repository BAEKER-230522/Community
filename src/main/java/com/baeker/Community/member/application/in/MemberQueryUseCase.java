package com.baeker.Community.member.application.in;

import com.baeker.Community.member.domain.Member;

public interface MemberQueryUseCase {

    Member byMemberId(Long memberId);
}
