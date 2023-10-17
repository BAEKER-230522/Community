package com.baeker.Community.member.adapter.in;

import com.baeker.Community.global.jwt.JwtDecrypt;
import com.baeker.Community.member.application.in.MemberQueryUseCase;
import com.baeker.Community.member.domain.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Member")
@RestController
@RequestMapping("${custom.mapping.member.web_usr}")
@RequiredArgsConstructor
public class MemberQueryController {

    private final MemberQueryUseCase memberQueryUseCase;
    private final JwtDecrypt decrypt;


    @Operation(summary = "게재한 모든 게시물 목록")
    @GetMapping("/v1/post")
    public ResponseEntity findPostings(
            @RequestHeader("Authorization") String token
    ) {
        return null;
    }

    @Operation(summary = "추천한 게시물 목록")
    @GetMapping("/v1/following")
    public ResponseEntity findFollowing(
            @RequestHeader("Authorization") String token
    ) {
        Long memberId = decrypt.getMemberId(token);
        Member member = memberQueryUseCase.byMemberId(memberId);
        return ResponseEntity.ok(member.getFollowing());
    }
}
