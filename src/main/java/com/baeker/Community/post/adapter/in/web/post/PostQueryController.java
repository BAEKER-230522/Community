package com.baeker.Community.post.adapter.in.web.post;

import com.baeker.Community.comment.application.port.in.comment.CommentQueryUseCase;
import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.dto.resDto.PostResDto;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import com.baeker.Community.post.domain.post.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "POST - 게시물 조회")
@RestController
@RequestMapping("${custom.mapping.post.web}")
@RequiredArgsConstructor
public class PostQueryController {

    private final PostQueryUseCase postQueryUseCase;
    private final CommentQueryUseCase commentQueryUseCase;


    @Operation(summary = "personal study rule id 로 게시물 조회")
    @GetMapping("/v1/personal/{personalId}")
    public ResponseEntity<PostResDto> findByPersonalId(
            @PathVariable Long personalId
    ) {
        Post post = postQueryUseCase.byPersonalId(personalId);
        List<Comment> comments = commentQueryUseCase.byPost(post);
        return ResponseEntity.ok(new PostResDto(post, comments));
    }

    @Operation(summary = "게시물을 추천한 회원 목록")
    @GetMapping("/v1/follower/{postId}")
    public ResponseEntity findFollowers(
            @PathVariable String postId
    ) {
        Post post = postQueryUseCase.byId(postId);
        return ResponseEntity.ok(post.getFollowers());
    }
}
