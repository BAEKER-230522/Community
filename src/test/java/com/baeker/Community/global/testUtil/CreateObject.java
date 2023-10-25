package com.baeker.Community.global.testUtil;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.post.domain.CodeReview;
import com.baeker.Community.post.domain.Post;

public class CreateObject {

    public static Post createPost(Long memberId, Long postId) {
        return CodeReview
                .forTest(memberId, postId, "post", "hello");
    }

    public static Post createPost(Long memberId) {
        return CodeReview
                .forTest(memberId, 1L, "post", "hello");
    }
}
