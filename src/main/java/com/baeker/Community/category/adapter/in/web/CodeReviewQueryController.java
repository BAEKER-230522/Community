package com.baeker.Community.category.adapter.in.web;

import com.baeker.Community.category.application.prot.in.codeReview.CodeReviewQueryUseCase;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "MISSION")
@RestController
@RequestMapping("${custom.mapping.mission.web_pub}")
@RequiredArgsConstructor
public class CodeReviewQueryController {

    private final CodeReviewQueryUseCase codeReviewQueryUseCase;


    @Operation(summary = "mission, member id 로 미션 코드리뷰 목록 조회")
    @GetMapping("/v1/mission/{missionId}/{memberId}")
    public ResponseEntity<List<CodeReviewDto>> byMissionId(
            @PathVariable Long missionId,
            @PathVariable Long memberId

    ) {
        List<CodeReviewDto> resDto = codeReviewQueryUseCase.byMissionAndMember(missionId, memberId);
        return ResponseEntity.ok(resDto);
    }
}
