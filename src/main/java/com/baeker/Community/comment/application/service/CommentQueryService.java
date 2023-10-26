package com.baeker.Community.comment.application.service;

import com.baeker.Community.comment.application.port.in.CommentQueryUseCase;
import com.baeker.Community.comment.application.port.out.CommentQueryRepositoryPort;
import com.baeker.Community.comment.application.port.out.CommentRepositoryPort;
import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.dto.resDto.CommentDto;
import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentQueryService implements CommentQueryUseCase {

    private final CommentQueryRepositoryPort queryRepository;
    private final CommentRepositoryPort repository;


    @Override
    public Comment byId(Long commentId) {
        Optional<Comment> byId = repository.findById(commentId);

        if (byId.isPresent())
            return byId.get();

        throw new NotFoundException("존재하지 않는 댓글");
    }

    @Override
    public List<CommentDto> byPost(Post post) {
        List<CommentDto> resDtos = queryRepository.byPost(post);

        if (resDtos.size() > 0)
            return resDtos;

        throw new NotFoundException("댓글이 존재하지 않습니다.");
    }
}
