package com.baeker.Community.member.application.in.member;

import com.baeker.Community.member.domain.Member;
import com.baeker.Community.member.domain.embedded.Posting;

public interface MemberModifyUseCase {

    void posting(Long memberId, Posting posting);

    void follow(Member member, String postId);

    void unfollow(Member member, String postId);
}
