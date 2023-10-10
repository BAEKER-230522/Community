package com.baeker.Community.documentGroup.adapter.in.member;

import com.baeker.Community.documentGroup.application.in.member.MemberQueryUseCase;
import com.baeker.Community.documentGroup.domain.Member;
import com.baeker.Community.global.jwt.JwtDecrypt;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Member - 커뮤니티 활동 내역 조회")
@RestController
@RequestMapping("${custom.mapping.member.web}")
@RequiredArgsConstructor
public class MemberQueryController {

    private final MemberQueryUseCase memberQueryUseCase;
    private final JwtDecrypt decrypt;


    @Operation(summary = "게재한 모든 게시물 목록")
    @GetMapping("/v1/post")
    public ResponseEntity findPostings(
            @RequestHeader("Authorization") String token
    ) {
        Long memberId = decrypt.getMemberId(token);
        Member member = memberQueryUseCase.byMemberId(memberId);
        return ResponseEntity.ok(member.getPostings());
    }
}
