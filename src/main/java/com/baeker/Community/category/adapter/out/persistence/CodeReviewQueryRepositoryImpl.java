package com.baeker.Community.category.adapter.out.persistence;

import com.baeker.Community.category.application.prot.out.CodeReviewQueryRepositoryPort;
import com.baeker.Community.category.domain.QCodeReview;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.dto.resDto.QCodeReviewDto;
import com.baeker.Community.post.domain.QPost;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CodeReviewQueryRepositoryImpl implements CodeReviewQueryRepositoryPort {

    private final JPAQueryFactory query;
    private QCodeReview cr = QCodeReview.codeReview;
    private QPost p = QPost.post;

    @Override
    public List<CodeReviewDto> problemStatusId(Long problemStatusId) {
        return query
                .select(codeReviewDto())
                .from(cr)
                .join(cr.post, p)
                .where(cr.problemStatusId.eq(problemStatusId))
                .fetch();
    }

    @Override
    public List<CodeReviewDto> findCodeReviewDtoList(Long missionId, Long memberId) {
        return query
                .select(codeReviewDto())
                .from(cr)
                .join(cr.post, p)
                .where(cr.missionId.eq(missionId)
                        .and(cr.memberId.eq(memberId)))
                .fetch();
    }

    private QCodeReviewDto codeReviewDto() {
        return new QCodeReviewDto(
                p.id,
                p.memberId,
                cr.problemStatusId,
                p.createDate,
                p.pageView,
                p.followList.size(),
                p.title,
                p.content,
                p.commentList
        );
    }
}
