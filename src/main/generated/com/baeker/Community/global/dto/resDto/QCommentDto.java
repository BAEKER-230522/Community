package com.baeker.Community.global.dto.resDto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.baeker.Community.global.dto.resDto.QCommentDto is a Querydsl Projection type for CommentDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCommentDto extends ConstructorExpression<CommentDto> {

    private static final long serialVersionUID = 2145130537L;

    public QCommentDto(com.querydsl.core.types.Expression<Long> commentId, com.querydsl.core.types.Expression<Long> postId, com.querydsl.core.types.Expression<java.time.LocalDateTime> createDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> modifyDate, com.querydsl.core.types.Expression<String> content) {
        super(CommentDto.class, new Class<?>[]{long.class, long.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, String.class}, commentId, postId, createDate, modifyDate, content);
    }

}

