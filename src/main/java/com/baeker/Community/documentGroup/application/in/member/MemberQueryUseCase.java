package com.baeker.Community.documentGroup.application.in.member;

import com.baeker.Community.documentGroup.domain.Member;

public interface MemberQueryUseCase {

    Member byMemberId(Long memberId);
}
