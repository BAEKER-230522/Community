package com.baeker.Community.post.adapter.out;

import com.baeker.Community.comment.domain.QComment;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.post.application.port.out.persistence.CodeReviewQueryRepositoryPort;
import com.baeker.Community.post.domain.QCodeReview;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CodeReviewQueryRepositoryAdapter implements CodeReviewQueryRepositoryPort {

    private final JPAQueryFactory query;
    private QCodeReview cr = QCodeReview.codeReview;
    private QComment cm = QComment.comment;

    @Override
    public List<CodeReviewDto> byMissionAndMemberId(Long missionId, Long memberId) {
        return null;
    }

}
