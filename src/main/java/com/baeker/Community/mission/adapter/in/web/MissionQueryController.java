package com.baeker.Community.mission.adapter.in.web;

import com.baeker.Community.global.dto.resDto.ChallengerResDto;
import com.baeker.Community.mission.application.prot.in.MissionQueryUseCase;
import com.baeker.Community.mission.domain.Mission;
import com.baeker.Community.post.application.port.in.CodeReviewQueryUseCase;
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
public class MissionQueryController {

    private final MissionQueryUseCase missionQueryUseCase;
    private final CodeReviewQueryUseCase postQueryUseCase;

    @Operation(summary = "mission id 로 미션 코드리뷰 목록 조회")
    @GetMapping("/v1/mission/{missionId}")
    public ResponseEntity<List<ChallengerResDto>> byMissionId(
            @PathVariable Long missionId
    ) {
//        Mission mission = missionQueryUseCase.byMissionId(missionId);
//        List<ChallengerResDto> resDtos = postQueryUseCase.toChallengerDto(mission.getChallengerList());
//        return ResponseEntity.ok(resDtos);
        return null;
    }
}
