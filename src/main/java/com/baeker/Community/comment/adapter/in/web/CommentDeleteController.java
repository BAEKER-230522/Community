package com.baeker.Community.comment.adapter.in.web;

import com.baeker.Community.comment.application.port.in.CommentDeleteUseCase;
import com.baeker.Community.comment.application.port.in.CommentQueryUseCase;
import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.jwt.JwtDecrypt;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "COMMENT")
@RestController
@RequestMapping("${custom.mapping.comment.web_usr}")
@RequiredArgsConstructor
public class CommentDeleteController {

    private final CommentQueryUseCase commentQueryUseCase;
    private final CommentDeleteUseCase commentDeleteUseCase;
    private final JwtDecrypt decrypt;


    @Operation(summary = "댓글 삭제")
    @DeleteMapping("/v1/{commentId}")
    public ResponseEntity deleteComment(
            @RequestHeader("Authorization") String token,
            @PathVariable Long commentId
    ) {
        Long memberId = decrypt.getMemberId(token);
        Comment comment = commentQueryUseCase.byId(commentId);
        commentDeleteUseCase.comment(memberId, comment);
        return ResponseEntity.noContent().build();
    }
}
