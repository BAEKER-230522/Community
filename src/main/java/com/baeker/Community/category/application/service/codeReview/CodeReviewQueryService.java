package com.baeker.Community.category.application.service.codeReview;

import com.baeker.Community.category.application.prot.in.codeReview.CodeReviewQueryUseCase;
import com.baeker.Community.category.application.prot.out.CodeReviewQueryRepositoryPort;
import com.baeker.Community.category.application.prot.out.CodeReviewRepositoryPort;
import com.baeker.Community.category.domain.CodeReview;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.exception.service.NotFoundException;
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

    private final CodeReviewQueryRepositoryPort queryRepository;
    private final CodeReviewRepositoryPort repository;

    @Override
    public CodeReview byProblemStatusId(Long problemStatusId) {
        Optional<CodeReview> byProblemStatusId = repository.findByProblemStatusId(problemStatusId);

        if (byProblemStatusId.isPresent())
            return byProblemStatusId.get();

        throw new NotFoundException("존재하지 않는 게시물");
    }

    @Override
    public List<CodeReviewDto> byMissionAndMember(Long missionId, Long memberId) {
//        return queryRepository.findCodeReviewDtoList(memberId, memberId);

        List<CodeReview> codeReviewList = repository.findByMissionIdAndMemberId(missionId, memberId);
        return codeReviewList.stream()
                .map(CodeReviewDto::new)
                .collect(Collectors.toList());
    }
}
