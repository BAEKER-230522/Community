package com.baeker.Community.comment.application.port.in.comment;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.post.domain.post.Post;

import java.util.List;

public interface CommentQueryUseCase {

    List<Comment> byPost(Post post);
}
