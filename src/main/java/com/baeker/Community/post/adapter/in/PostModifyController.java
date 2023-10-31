package com.baeker.Community.post.adapter.in;

import com.baeker.Community.global.dto.ResponseData;
import com.baeker.Community.global.dto.reqDto.ModifyPostDto;
import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.global.jwt.JwtDecrypt;
import com.baeker.Community.post.application.port.in.post.PostModifyUseCase;
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
public class PostModifyController {

    private final PostModifyUseCase postModifyUseCase;
    private final PostQueryUseCase postQueryUseCase;
    private final JwtDecrypt decrypt;


    @Operation(summary = "게시물 수정")
    @PatchMapping("/v1/post")
    public ResponseData<PostDto> modifyPost(
            @RequestHeader("Authorization") String token,
            @RequestBody ModifyPostDto dto
    ) {
        Long memberId = decrypt.getMemberId(token);
        Post post = postQueryUseCase.byId(dto.getPostId());
        PostDto resDto = postModifyUseCase.post(memberId, post, dto);
        return ResponseData.ok(resDto);
    }

    @Operation(summary = "게시물 추천, 추천 취소")
    @PatchMapping("/v1/follow/{postId}")
    public ResponseData follow(
            @RequestHeader("Authorization") String token,
            @PathVariable Long postId
    ) {
        Long memberId = decrypt.getMemberId(token);
        Post post = postQueryUseCase.byId(postId);
        postModifyUseCase.follow(memberId, post);
        return ResponseData.noContent();
    }
}
