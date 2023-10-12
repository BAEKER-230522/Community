package com.baeker.Community.post.application.port.in.post;

import com.baeker.Community.member.domain.Member;

public interface PostModifyUseCase {



    void follow(Member member, Long postId);
}
