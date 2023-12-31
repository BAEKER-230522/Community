package com.baeker.Community.comment.adapter.in.web;

import com.baeker.Community.comment.application.port.in.CommentCreateUSeCase;
import com.baeker.Community.global.dto.reqDto.CreateCommentDto;
import com.baeker.Community.global.dto.resDto.CommentDto;
import com.baeker.Community.global.jwt.JwtDecrypt;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import com.baeker.Community.post.domain.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "COMMENT")
@RestController
@RequestMapping("${custom.mapping.comment.web_usr}")
@RequiredArgsConstructor
public class CommentCreateController {

    private final CommentCreateUSeCase commentCreateUSeCase;
    private final PostQueryUseCase postQueryUseCase;
    private final JwtDecrypt decrypt;


    @Operation(summary = "댓글 작성")
    @PostMapping("/v1")
    public ResponseEntity<CommentDto> writeComment(
            @RequestHeader("Authorization") String token,
            @RequestBody CreateCommentDto dto
    ) {
        Long memberId = decrypt.getMemberId(token);
        Post post = postQueryUseCase.byId(dto.getPostId());
        CommentDto resDto = commentCreateUSeCase.write(memberId, post, dto.getContent());
        return ResponseEntity.ok(resDto);
    }
}
