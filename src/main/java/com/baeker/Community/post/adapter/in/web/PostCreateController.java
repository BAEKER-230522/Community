package com.baeker.Community.post.adapter.in.web;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.post.application.port.in.CodeReviewCreateUseCase;
import com.baeker.Community.global.jwt.JwtDecrypt;
import com.baeker.Community.post.application.port.in.CodeReviewQueryUseCase;
import com.baeker.Community.post.domain.category.CodeReview;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "POST")
@RestController
@RequestMapping("${custom.mapping.post.web_usr}")
@RequiredArgsConstructor
public class PostCreateController {

    private final CodeReviewCreateUseCase codeReviewCreateUseCase;
    private final CodeReviewQueryUseCase codeReviewQueryUseCase;
    private final JwtDecrypt decrypt;

    @Operation(summary = "미션 코드리뷰 게시물 작성")
    @PostMapping("/v1/code-review")
    public ResponseEntity<CodeReviewDto> createMission(
            @RequestHeader("Authorization") String token,
            @RequestBody @Valid CreateCodeReviewDto dto
    ) {
        Long memberId = decrypt.getMemberId(token);
        CodeReview codeReview = codeReviewQueryUseCase.byProblemStatusId(dto.getProblemStatusId());
        CodeReviewDto resDto = codeReviewCreateUseCase.write(memberId, dto, codeReview);
        return ResponseEntity.ok(resDto);
    }
}
