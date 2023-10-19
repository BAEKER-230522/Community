package com.baeker.Community.category.adapter.out.persistence;

import com.baeker.Community.category.application.prot.out.CodeReviewQueryRepositoryPort;
import com.baeker.Community.category.domain.QCodeReview;
import com.baeker.Community.global.dto.resDto.ChallengerDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.dto.resDto.QCodeReviewDto;
import com.baeker.Community.post.domain.QPost;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CodeReviewQueryRepository implements CodeReviewQueryRepositoryPort {

    private final JPAQueryFactory query;
    private QCodeReview cr = QCodeReview.codeReview;
    private QPost p = QPost.post;

    @Override
    public List<ChallengerDto> findByMissionId(Long missionId) {

        List<Tuple> result = query
                .select(p.memberId, codeReviewDto())
                .from(cr)
                .join(cr.post, p)
                .where(cr.missionId.eq(missionId))
                .groupBy(p.memberId)
                .fetch();

        return result.stream()
                .map(tuple -> {
                    Long memberId = tuple.get(p.memberId);
                    CodeReviewDto codeReview = tuple.get(codeReviewDto());
                    return new ChallengerDto(memberId, Collections.singletonList(codeReview));
                })
                .collect(Collectors.toList());
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
