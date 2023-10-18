package com.baeker.Community.member.application.in;

import com.baeker.Community.member.domain.Member;
import com.baeker.Community.post.domain.category.CodeReview;

public interface MemberModifyUseCase {

    void posting(Long memberId, CodeReview codeReview);

    void follow(Member member, CodeReview codeReview);

    void unfollow(Member member, CodeReview codeReview);
}
