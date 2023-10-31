package com.baeker.Community.comment.adapter.out;

import com.baeker.Community.comment.application.port.out.CommentQueryRepositoryPort;
import com.baeker.Community.comment.domain.QComment;
import com.baeker.Community.global.dto.resDto.CommentDto;
import com.baeker.Community.global.dto.resDto.QCommentDto;
import com.baeker.Community.post.domain.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentQueryRepositoryAdapter implements CommentQueryRepositoryPort {

    private final JPAQueryFactory query;
    private QComment cm = QComment.comment;

    @Override
    public List<CommentDto> byPost(Post post) {
        return query
                .select(commentDto())
                .from(cm)
                .where(cm.post.eq(post))
                .fetch();
    }


    private QCommentDto commentDto() {
        return new QCommentDto(
                cm.id,
                cm.post.id,
                cm.memberId,
                cm.createDate,
                cm.modifyDate,
                cm.content
        );
    }
}
