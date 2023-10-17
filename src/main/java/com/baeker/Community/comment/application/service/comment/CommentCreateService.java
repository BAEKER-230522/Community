package com.baeker.Community.comment.application.service.comment;

import com.baeker.Community.comment.application.port.in.comment.CommentCreateUseCase;
import com.baeker.Community.comment.application.port.out.CommentRepositoryPort;
import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.comment.domain.Comments;
import com.baeker.Community.post.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentCreateService implements CommentCreateUseCase {

    private final CommentRepositoryPort repository;
    private final MongoTemplate mongoTemplate;


    @Override
    public void write(Long memberId, String content, Post post) {
        Comment comment = repository.save(
                Comment.create(memberId, content));

//        updateComments(comment, post.getComments());
    }

    private void updateComments(Comment comment, Comments comments) {
        comments.getComments().add(comment.getId());
        mongoTemplate.save(comments);
    }
}
