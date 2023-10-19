package com.baeker.Community.member.application.in;

import com.baeker.Community.member.domain.Member;
import com.baeker.Community.post.domain.post.Post;

public interface MemberModifyUseCase {

    void follow(Member member, Post post);

    void unfollow(Member member, Post post);
}
