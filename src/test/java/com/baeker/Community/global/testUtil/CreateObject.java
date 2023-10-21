package com.baeker.Community.global.testUtil;

import com.baeker.Community.post.domain.Post;

public class CreateObject {

    public static Post createPost(Long memberId, Long postId) {
        return Post.forTest(memberId, postId, "post", "hello");
    }

    public static Post createPost(Long memberId) {
        return Post.forTest(memberId, 1L, "post", "hello");
    }
}
