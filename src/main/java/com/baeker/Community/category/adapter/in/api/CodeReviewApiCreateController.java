package com.baeker.Community.category.adapter.in.api;

import com.baeker.Community.category.application.prot.in.CodeReview.CodeReviewCreateUseCase;
import com.baeker.Community.global.dto.reqDto.SettingMissionDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "CODE_REVIEW - 서버간 통신")
@RestController
@RequestMapping("${custom.mapping.mission.api}")
@RequiredArgsConstructor
public class CodeReviewApiCreateController {

    private final CodeReviewCreateUseCase missionCreateUseCase;


    @Operation(summary = "미션 생성시 게시판 세팅 api")
    @PostMapping("/v1/setting")
    public ResponseEntity setting(
            @RequestBody SettingMissionDto dto
    ) {
        missionCreateUseCase.setting(dto);
        return ResponseEntity.noContent().build();
    }
}
