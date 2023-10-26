package com.baeker.Community.comment.application.service;

import com.baeker.Community.comment.application.port.in.CommentModifyUseCase;
import com.baeker.Community.comment.application.port.out.CommentRepositoryPort;
import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.dto.resDto.CommentDto;
import com.baeker.Community.global.exception.service.NoPermissionException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentModifyService implements CommentModifyUseCase {

    private final CommentRepositoryPort repository;


    @Override
    public CommentDto comment(Long memberId, Comment comment, String content) {
        isWriter(memberId, comment);

        Comment modifyComment = repository.save(
                comment.modifyContent(content)
        );
        return new CommentDto(modifyComment);
    }


    private void isWriter(Long memberId, Comment comment) {
        if (memberId != comment.getMemberId())
            throw new NoPermissionException("수정 권한이 없습니다.");
    }
}
