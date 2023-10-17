package com.baeker.Community.post.adapter.in.web;

import com.baeker.Community.post.application.port.in.CodeReviewQueryUseCase;
import com.baeker.Community.post.domain.post.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "POST")
@RestController
@RequestMapping("${custom.mapping.post.web_pub}")
@RequiredArgsConstructor
public class PostQueryController {

    private final CodeReviewQueryUseCase postQueryUseCase;


    @Operation(summary = "게시물을 추천한 회원 목록")
    @GetMapping("/v1/follower/{postId}")
    public ResponseEntity findFollowers(
            @PathVariable String postId
    ) {
//        Post post = postQueryUseCase.byId(postId);
//        return ResponseEntity.ok(post.getFollowers());
        return null;
    }
}
