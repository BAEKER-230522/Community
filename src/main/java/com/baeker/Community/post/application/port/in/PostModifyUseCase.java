package com.baeker.Community.post.application.port.in;

import com.baeker.Community.member.domain.Member;

public interface PostModifyUseCase {



    void follow(Member member, Long postId);
}
