package com.baeker.Community.member.application.in.member;

import com.baeker.Community.member.domain.embedded.Posting;

public interface MemberModifyUseCase {

    void posting(Long memberId, Posting posting);
}
