package com.baeker.Community.global.testUtil;

import com.baeker.Community.post.domain.Post;

public class CreateObject {

    public static Post createPost(Long memberId, Long postId) {
        return Post.forTest(memberId, postId, "post", "hello");
    }
}
