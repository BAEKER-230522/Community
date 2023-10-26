package com.baeker.Community.post.adapter.in;

import com.baeker.Community.global.jwt.JwtDecrypt;
import com.baeker.Community.post.application.port.in.post.PostDeleteUseCase;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
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
public class PostDeleteController {

    private final PostQueryUseCase postQueryUseCase;
    private final PostDeleteUseCase postDeleteUseCase;
    private final JwtDecrypt decrypt;


    @Operation(summary = "게시글 삭제")
    @DeleteMapping("/v1/{postId}")
    public ResponseEntity deletePost(
            @RequestHeader("Authorization") String token,
            @PathVariable Long postId
    ) {
        Long memberId = decrypt.getMemberId(token);
        Post post = postQueryUseCase.byId(postId);
        postDeleteUseCase.post(memberId, post);
        return ResponseEntity.noContent().build();
    }
}
