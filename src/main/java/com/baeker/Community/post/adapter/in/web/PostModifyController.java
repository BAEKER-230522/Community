package com.baeker.Community.post.adapter.in.web;

import com.baeker.Community.global.jwt.JwtDecrypt;
import com.baeker.Community.member.application.in.MemberQueryUseCase;
import com.baeker.Community.member.domain.Member;
import com.baeker.Community.post.application.port.in.PostModifyUseCase;
import com.baeker.Community.post.application.port.in.PostQueryUseCase;
import com.baeker.Community.post.domain.post.Post;
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
    private final MemberQueryUseCase memberQueryUseCase;
    private final JwtDecrypt decrypt;


    @Operation(summary = "게시물 추천, 추천 취소")
    @PatchMapping("/v1/follow/{problemStatusId}")
    public ResponseEntity follow(
            @RequestHeader("Authorization") String token,
            @PathVariable Long problemStatusId
    ) {
        Long memberId = decrypt.getMemberId(token);
        Member member = memberQueryUseCase.byMemberId(memberId);
        Post post = postQueryUseCase.byProblemStatusId(problemStatusId);
        postModifyUseCase.follow(member, post);
        return ResponseEntity.noContent().build();
    }
}
