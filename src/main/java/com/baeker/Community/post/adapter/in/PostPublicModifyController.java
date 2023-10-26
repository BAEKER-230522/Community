package com.baeker.Community.post.adapter.in;

import com.baeker.Community.post.application.port.in.codeReview.CodeReviewQueryUseCase;
import com.baeker.Community.post.application.port.in.post.PostModifyUseCase;
import com.baeker.Community.post.domain.CodeReview;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "POST")
@RestController
@RequestMapping("${custom.mapping.post.web_pub}")
@RequiredArgsConstructor
public class PostPublicModifyController {

    private final CodeReviewQueryUseCase codeReviewQueryUseCase;
    private final PostModifyUseCase postModifyUseCase;

    @Operation(summary = "코드리뷰 게시물 조회수 추가")
    @PatchMapping("/v1/pageView/{problemStatusId}")
    public ResponseEntity addPageView(
            @PathVariable Long problemStatusId
    ) {
        CodeReview codeReview = codeReviewQueryUseCase.byProblemStatusId(problemStatusId);
        postModifyUseCase.addPageView(codeReview);
        return ResponseEntity.noContent().build();
    }
}
