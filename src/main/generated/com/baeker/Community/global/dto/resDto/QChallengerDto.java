package com.baeker.Community.global.dto.resDto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.baeker.Community.global.dto.resDto.QChallengerDto is a Querydsl Projection type for ChallengerDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QChallengerDto extends ConstructorExpression<ChallengerDto> {

    private static final long serialVersionUID = 1832512807L;

    public QChallengerDto(com.querydsl.core.types.Expression<Long> memberId, com.querydsl.core.types.Expression<? extends java.util.List<CodeReviewDto>> codeReviewList) {
        super(ChallengerDto.class, new Class<?>[]{long.class, java.util.List.class}, memberId, codeReviewList);
    }

}

