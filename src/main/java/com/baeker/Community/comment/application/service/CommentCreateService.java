package com.baeker.Community.comment.application.service;

import com.baeker.Community.comment.application.port.in.CommentCreateUSeCase;
import com.baeker.Community.comment.application.port.out.CommentRepositoryPort;
import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.dto.reqDto.CreateCommentDto;
import com.baeker.Community.global.dto.resDto.CommentDto;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentCreateService implements CommentCreateUSeCase {

    private final CommentRepositoryPort repository;


    @Override
    public CommentDto write(Long memberId, Post post, CreateCommentDto dto) {
        Comment comment = repository.save(
                Comment.write(memberId, post, dto)
        );
        return new CommentDto(comment);
    }
}
