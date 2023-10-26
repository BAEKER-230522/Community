package com.baeker.Community.comment.adapter.in.web;

import com.baeker.Community.comment.application.port.in.CommentModifyUseCase;
import com.baeker.Community.comment.application.port.in.CommentQueryUseCase;
import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.dto.reqDto.ModifyCommentDto;
import com.baeker.Community.global.dto.resDto.CommentDto;
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
public class CommentModifyController {

    private final CommentQueryUseCase commentQueryUseCase;
    private final CommentModifyUseCase commentModifyUseCase;
    private final JwtDecrypt decrypt;


    @Operation(summary = "댓글 수정")
    @PatchMapping("/v1/content")
    public ResponseEntity<CommentDto> modifyContent(
            @RequestHeader("Authorization") String token,
            @RequestBody ModifyCommentDto dto
    ) {
        Long memberId = decrypt.getMemberId(token);
        Comment comment = commentQueryUseCase.byId(dto.getCommentId());
        CommentDto resDto = commentModifyUseCase.content(memberId, comment, dto.getContent());
        return ResponseEntity.ok(resDto);
    }
}
