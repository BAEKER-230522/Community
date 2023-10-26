package com.baeker.Community.comment.application.service;

import com.baeker.Community.comment.application.port.in.CommentDeleteUseCase;
import com.baeker.Community.comment.application.port.out.CommentRepositoryPort;
import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.exception.service.NoPermissionException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentDeleteService implements CommentDeleteUseCase {

    private final CommentRepositoryPort repository;


    @Override
    public void comment(Long memberId, Comment comment) {
        isWriter(memberId, comment);

        comment.delete();
        repository.delete(comment);
    }


    private void isWriter(Long memberId, Comment comment) {
        if (comment.getMemberId() != memberId)
            throw new NoPermissionException("권한이 없습니다.");
    }
}
