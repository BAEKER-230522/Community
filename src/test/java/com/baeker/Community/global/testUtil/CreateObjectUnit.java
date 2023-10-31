package com.baeker.Community.global.testUtil;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.post.domain.CodeReview;
import com.baeker.Community.post.domain.Post;

public class CreateObjectUnit {

    public static Post createPost(Long memberId, Long postId) {
        return CodeReview.builder()
                .id(postId)
                .memberId(memberId)
                .title("post")
                .content("hello")
                .build();
    }

    public static Comment createComment(Long memberId, Long commentId, Post post) {
        Comment comment = Comment.builder()
                .id(commentId)
                .memberId(memberId)
                .post(post)
                .content("hello")
                .build();

        post.getCommentList().add(comment);
        return comment;
    }
}
