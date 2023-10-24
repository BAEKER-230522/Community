package com.baeker.Community.category.adapter.out.persistence;

import com.baeker.Community.category.application.prot.out.CodeReviewQueryRepositoryPort;
import com.baeker.Community.category.domain.QCodeReview;
import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.comment.domain.QComment;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.dto.resDto.QCodeReviewDto;
import com.baeker.Community.post.domain.Post;
import com.baeker.Community.post.domain.QPost;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.criteria.JpaSubQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CodeReviewQueryRepositoryImpl implements CodeReviewQueryRepositoryPort {

    private final JPAQueryFactory query;
    private QCodeReview cr = QCodeReview.codeReview;
    private QPost p = QPost.post;
    private QComment cm = QComment.comment;

    @Override
    public List<CodeReviewDto> problemStatusId(Long postId) {
//        return query
//                .select(codeReviewDto())
//                .from(p)
//                .leftJoin(p.commentList, cm)
//                .where(p.id.eq(postId))
//                .fetch();
        return null;
    }

    @Override
    public List<CodeReviewDto> findCodeReviewDtoList(Long missionId, Long memberId) {
//        return query
//                .select(codeReviewDto())
//                .from(cr)
//                .join(cr.post, p)
//                .leftJoin(p.commentList, cm)
//                .where(cr.missionId.eq(missionId)
//                        .and(cr.memberId.eq(memberId)))
//                .fetch();
        return null;
    }

//    private QCodeReviewDto codeReviewDto() {
//        return new QCodeReviewDto(
//                p.id,
//                p.memberId,
//                cr.problemStatusId,
//                p.createDate,
//                p.pageView,
//                p.followList.size(),
//                p.title,
//                p.content,
//                commentList()
//        );
//    }
//
//    private Expression<Comment> commentList() {
//        return ExpressionUtils.as(
//                JPAExpressions
//                        .selectFrom(cm)
//                        .where(cm.post.eq(p)),
//                "commentList"
//        );
//    }
}
