package com.baeker.Community.post.adapter.in.web;

import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.post.application.port.in.codeReview.CodeReviewQueryUseCase;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import com.baeker.Community.post.domain.CodeReview;
import com.baeker.Community.post.domain.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "POST")
@RestController
@RequestMapping("${custom.mapping.post.web_pub}")
@RequiredArgsConstructor
public class PostQueryController {

    private final PostQueryUseCase postQueryUseCase;
    private final CodeReviewQueryUseCase codeReviewQueryUseCase;


    @Operation(summary = "post id 로 게시물 조회")
    @GetMapping("/v1/post/{postId}")
    public ResponseEntity<PostDto> findByPostId(
            @PathVariable Long postId
    ) {
        Post post = postQueryUseCase.byId(postId);
        PostDto resDto = new PostDto(post);
        return ResponseEntity.ok(resDto);
    }

    @Operation(summary = "problem status id 로 게시물 조회")
    @GetMapping("/v1/problem-status/{problemStatusId}")
    public ResponseEntity<CodeReviewDto> findByProblemStatusId(
            @PathVariable Long problemStatusId
    ) {
        CodeReview codeReview = codeReviewQueryUseCase.byProblemStatusId(problemStatusId);
        CodeReviewDto resDto = new CodeReviewDto(codeReview);
        return ResponseEntity.ok(resDto);
    }

    @Operation(summary = "게시물을 추천한 회원 목록")
    @GetMapping("/v1/follower/{postId}")
    public ResponseEntity<List<Long>> findFollowers(
            @PathVariable Long postId
    ) {
        Post post = postQueryUseCase.byId(postId);
        return ResponseEntity.ok(post.getFollows());
    }
}
