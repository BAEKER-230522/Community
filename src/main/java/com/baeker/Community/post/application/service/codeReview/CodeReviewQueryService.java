package com.baeker.Community.post.application.service.codeReview;

import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.post.application.port.in.codeReview.CodeReviewQueryUseCase;
import com.baeker.Community.post.application.port.out.CodeReviewQueryRepositoryPort;
import com.baeker.Community.post.application.port.out.CodeReviewRepositoryPort;
import com.baeker.Community.post.domain.CodeReview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CodeReviewQueryService implements CodeReviewQueryUseCase {

    private final CodeReviewRepositoryPort repository;
    private final CodeReviewQueryRepositoryPort queryRepository;

    @Override
    public CodeReview byProblemStatusId(Long problemStatusId) {
        Optional<CodeReview> byProblemStatusId = repository.findByProblemStatusId(problemStatusId);

        if (byProblemStatusId.isPresent())
            return byProblemStatusId.get();

        throw new NotFoundException("존재하지 않는 게시물");
    }

    @Override
    public List<CodeReviewDto> byMission(Long missionId, Long memberId) {
        List<CodeReview> codeReivewList = repository.findByMissionIdAndMemberId(missionId, memberId);

        if (codeReivewList.size() == 0)
            throw new NotFoundException("등록한 게시물이 없습니다.");

        return codeReivewList.stream()
                .map(CodeReviewDto::new)
                .collect(Collectors.toList());
    }
}
