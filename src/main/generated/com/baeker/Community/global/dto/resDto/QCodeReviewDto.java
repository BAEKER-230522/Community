package com.baeker.Community.global.dto.resDto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.baeker.Community.global.dto.resDto.QCodeReviewDto is a Querydsl Projection type for CodeReviewDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCodeReviewDto extends ConstructorExpression<CodeReviewDto> {

    private static final long serialVersionUID = 1332477489L;

    public QCodeReviewDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> memberId, com.querydsl.core.types.Expression<Long> missionId, com.querydsl.core.types.Expression<Long> problemStatusId, com.querydsl.core.types.Expression<java.time.LocalDateTime> createDate, com.querydsl.core.types.Expression<Integer> pageView, com.querydsl.core.types.Expression<Integer> follower, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> content) {
        super(CodeReviewDto.class, new Class<?>[]{long.class, long.class, long.class, long.class, java.time.LocalDateTime.class, int.class, int.class, String.class, String.class}, id, memberId, missionId, problemStatusId, createDate, pageView, follower, title, content);
    }

}

