package com.baeker.Community.post.adapter.in;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.reqDto.CreateStudyPostDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.dto.resDto.StudyPostDto;
import com.baeker.Community.global.jwt.JwtDecrypt;
import com.baeker.Community.post.application.port.in.post.PostCreateUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "POST")
@RestController
@RequestMapping("${custom.mapping.post.web_usr}")
@RequiredArgsConstructor
public class PostCreateController {

    private final PostCreateUseCase postCreateUseCase;
    private final JwtDecrypt decrypt;

    @Operation(summary = "미션 코드리뷰 게시물 작성")
    @PostMapping("/v1/code-review")
    public ResponseEntity<CodeReviewDto> createCodeReview(
            @RequestHeader("Authorization") String token,
            @RequestBody CreateCodeReviewDto dto
    ) {
        Long memberId = decrypt.getMemberId(token);
        CodeReviewDto resDto = postCreateUseCase.codeReview(memberId, dto);
        return ResponseEntity.ok(resDto);
    }

    @Operation(summary = "스터디 전용 게시물 작성")
    @PostMapping("/v1/study")
    public ResponseEntity<StudyPostDto> createStudyPost(
            @RequestHeader("Authorization") String token,
            @RequestBody CreateStudyPostDto dto
    ) {
        Long memberId = decrypt.getMemberId(token);
        StudyPostDto resDto = postCreateUseCase.studyPost(memberId, dto);
        return ResponseEntity.ok(resDto);
    }
}
