package com.baeker.Community.post.adapter.in.web;

import com.baeker.Community.global.dto.reqDto.CreatePostDto;
import com.baeker.Community.global.dto.resDto.CodeReviewResDto;
import com.baeker.Community.mission.application.prot.in.MissionQueryUseCase;
import com.baeker.Community.mission.domain.Mission;
import com.baeker.Community.post.application.port.in.PostCreateUseCase;
import com.baeker.Community.global.jwt.JwtDecrypt;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "POST - 게시물 게재")
@RestController
@RequestMapping("${custom.mapping.post.web_usr}")
@RequiredArgsConstructor
public class PostCreateController {

    private final PostCreateUseCase postCreateUseCase;
    private final MissionQueryUseCase missionQueryUseCase;
    private final JwtDecrypt decrypt;

    @Operation(summary = "미션 문제 해결 게시물 게재")
    @PostMapping("/v1/mission")
    public ResponseEntity createMission(
            @RequestHeader("Authorization") String token,
            @RequestBody @Valid CreatePostDto dto
    ) {
        Long memberId = decrypt.getMemberId(token);
        Mission mission = missionQueryUseCase.byMissionId(dto.getMissionId());
        CodeReviewResDto resDto = postCreateUseCase.mission(memberId, dto, mission);
        return ResponseEntity.ok(resDto);
    }
}
