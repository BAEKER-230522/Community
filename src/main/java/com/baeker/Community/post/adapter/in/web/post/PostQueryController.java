package com.baeker.Community.post.adapter.in.web.post;

import com.baeker.Community.global.dto.resDto.PostResDto;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "POST - 게시물 조회")
@RestController
@RequestMapping("${custom.mapping.post.web}")
@RequiredArgsConstructor
public class PostQueryController {

    private final PostQueryUseCase postQueryUseCase;


    @Operation(summary = "personal study rule id 로 게시물 조회")
    @GetMapping("/v1/personal/{personalId}")
    public ResponseEntity<PostResDto> findByPersonalId(
            @PathVariable Long personalId
    ) {
        PostResDto resDto = postQueryUseCase.byPersonalId(personalId);
        return ResponseEntity.ok(resDto);
    }
}
