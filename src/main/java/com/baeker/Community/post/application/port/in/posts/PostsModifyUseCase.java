package com.baeker.Community.post.application.port.in.posts;

import com.baeker.Community.member.domain.embedded.Posting;

public interface PostsModifyUseCase {

    void posting(Long memberId, Long missionId, Posting posting);
}
