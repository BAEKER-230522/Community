package com.baeker.Community.comment.application.service;

import com.baeker.Community.comment.application.port.in.CommentQueryUseCase;
import com.baeker.Community.comment.application.port.out.CommentQueryRepositoryPort;
import com.baeker.Community.global.dto.resDto.CommentDto;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentQueryService implements CommentQueryUseCase {

    private final CommentQueryRepositoryPort queryRepository;


    @Override
    public List<CommentDto> byPost(Post post) {
        return queryRepository.byPost(post);
    }
}
