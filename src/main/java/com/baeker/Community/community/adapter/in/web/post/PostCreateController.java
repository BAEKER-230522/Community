package com.baeker.Community.community.adapter.in.web.post;

import com.baeker.Community.community.adapter.in.reqDto.CreatePostDto;
import com.baeker.Community.community.adapter.in.resDto.PostResDto;
import com.baeker.Community.community.application.port.in.post.PostCreateUseCase;
import com.baeker.Community.global.jwt.JwtDecrypt;
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
    public ResponseEntity create(
            @RequestHeader("Authorization") String token,
            @RequestBody CreatePostDto dto
    ) {
        Long memberId = decrypt.getMemberId(token);
        PostResDto resDto = postCreateUseCase.post(memberId, dto);
        return ResponseEntity.ok(resDto);
    }
}
