package com.baeker.Community.post.adapter.in.web.post;

import com.baeker.Community.global.dto.reqDto.CreatePostDto;
import com.baeker.Community.global.dto.resDto.PostResDto;
import com.baeker.Community.post.application.port.in.post.PostCreateUseCase;
import com.baeker.Community.global.jwt.JwtDecrypt;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${custom.mapping.post.web}")
@RequiredArgsConstructor
public class PostCreateController {

    private final PostCreateUseCase postCreateUseCase;
    private final JwtDecrypt decrypt;

    @PostMapping("/v1")
    public ResponseEntity createMission(
            @RequestHeader("Authorization") String token,
            @RequestBody @Valid CreatePostDto dto
    ) {
        Long memberId = decrypt.getMemberId(token);
        PostResDto resDto = postCreateUseCase.Mission(memberId, dto);
        return ResponseEntity.ok(resDto);
    }
}
