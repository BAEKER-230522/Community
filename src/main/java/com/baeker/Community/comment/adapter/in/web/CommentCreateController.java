package com.baeker.Community.comment.adapter.in.web;

import com.baeker.Community.comment.application.port.in.comment.CommentCreateUseCase;
import com.baeker.Community.global.dto.reqDto.CreateCommentReqDto;
import com.baeker.Community.global.jwt.JwtDecrypt;
import com.baeker.Community.post.application.port.in.PostQueryUseCase;
import com.baeker.Community.post.domain.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "COMMENT - 댓글 작성")
@RestController
@RequestMapping("${custom.mapping.comment.web_usr}")
@RequiredArgsConstructor
public class CommentCreateController {

    private final CommentCreateUseCase commentCreateUseCase;
    private final PostQueryUseCase postQueryUseCase;
    private final JwtDecrypt decrypt;


    @Operation(summary = "게시물에 댓글 작성")
    @PostMapping("/v1")
    public ResponseEntity writeComment(
            @RequestHeader("Authorization") String token,
            @RequestBody CreateCommentReqDto dto
            ) {
        Long memberId = decrypt.getMemberId(token);
        Post post = postQueryUseCase.byId(dto.getPostId());
        commentCreateUseCase.write(memberId, dto.getComment(), post);
        return ResponseEntity.noContent().build();
    }
}
