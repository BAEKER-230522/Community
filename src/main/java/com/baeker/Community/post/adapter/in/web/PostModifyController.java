package com.baeker.Community.post.adapter.in.web;

import com.baeker.Community.global.jwt.JwtDecrypt;
import com.baeker.Community.post.application.port.in.PostModifyUseCase;
import com.baeker.Community.post.application.port.in.PostQueryUseCase;
import com.baeker.Community.post.domain.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "POST")
@RestController
@RequestMapping("${custom.mapping.post.web_usr}")
@RequiredArgsConstructor
public class PostModifyController {

    private final PostModifyUseCase postModifyUseCase;
    private final PostQueryUseCase postQueryUseCase;
    private final JwtDecrypt decrypt;


    @Operation(summary = "게시물 추천, 추천 취소")
    @PatchMapping("/v1/follow/{postId}")
    public ResponseEntity follow(
            @RequestHeader("Authorization") String token,
            @PathVariable Long postId
    ) {
        Long memberId = decrypt.getMemberId(token);
        Post post = postQueryUseCase.byId(postId);
        postModifyUseCase.follow(memberId, post);
        return ResponseEntity.noContent().build();
    }
}
