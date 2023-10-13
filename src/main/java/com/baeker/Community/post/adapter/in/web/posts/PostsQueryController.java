package com.baeker.Community.post.adapter.in.web.posts;

import com.baeker.Community.global.dto.resDto.PostsResDto;
import com.baeker.Community.post.application.port.in.posts.PostsQueryUseCase;
import com.baeker.Community.post.domain.posts.Posts;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "POSTS - 미션별 게시물 목록 조회")
@RestController
@RequestMapping("${custom.mapping.posts.web_pub}")
@RequiredArgsConstructor
public class PostsQueryController {

    private final PostsQueryUseCase postsQueryUseCase;


    @Operation(summary = "미션 id 로 게시물 목록 조회")
    @GetMapping("/v1/mission/{missionId}")
    public ResponseEntity findByMissionId(
            @PathVariable Long missionId
    ) {
        Posts posts = postsQueryUseCase.byMissionId(missionId);
        PostsResDto resDto = new PostsResDto(posts);
        return ResponseEntity.ok(resDto);
    }
}
