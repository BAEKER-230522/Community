package com.baeker.Community.post.adapter.in.web.post;

import com.baeker.Community.global.jwt.JwtDecrypt;
import com.baeker.Community.post.application.port.in.post.PostModifyUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "POST - 게시물 관련 수정")
@RestController
@RequestMapping("${custom.mapping.post.web}")
@RequiredArgsConstructor
public class PostModifyController {

    private final PostModifyUseCase postModifyUseCase;
    private final JwtDecrypt decrypt;


    @Operation(summary = "게시물 추천, 추천 취소")
    @PatchMapping("/v1/follow/{personalId}")
    public ResponseEntity follow(
            @RequestHeader("Authorization") String token,
            @PathVariable Long personalId
    ) {
        Long memberId = decrypt.getMemberId(token);
        postModifyUseCase.follow(memberId, personalId);
        return ResponseEntity.noContent().build();
    }
}
