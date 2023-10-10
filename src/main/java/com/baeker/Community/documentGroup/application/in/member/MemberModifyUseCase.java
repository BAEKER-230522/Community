package com.baeker.Community.documentGroup.application.in.member;

import com.baeker.Community.documentGroup.domain.Member;
import com.baeker.Community.documentGroup.domain.embedded.Posting;

public interface MemberModifyUseCase {

    void posting(Long memberId, Posting posting);
}
