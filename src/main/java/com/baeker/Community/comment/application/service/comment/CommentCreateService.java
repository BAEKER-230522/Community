package com.baeker.Community.comment.application.service.comment;

import com.baeker.Community.comment.application.port.in.comment.CommentCreateUseCase;
import com.baeker.Community.comment.application.port.out.CommentRepositoryPort;
import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentCreateService implements CommentCreateUseCase {

    private final CommentRepositoryPort repository;


    @Override
    public void write(Long memberId, String content, Post post) {
        repository.save(
                Comment.create(memberId, post, content)
        );
    }
}
