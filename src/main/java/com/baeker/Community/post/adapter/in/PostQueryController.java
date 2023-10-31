package com.baeker.Community.post.adapter.in;

import com.baeker.Community.global.dto.ResponseData;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.global.dto.resDto.StudyPostDto;
import com.baeker.Community.post.application.port.in.codeReview.CodeReviewQueryUseCase;
import com.baeker.Community.post.application.port.in.post.PostModifyUseCase;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import com.baeker.Community.post.application.port.in.study.StudyPostQueryUseCase;
import com.baeker.Community.post.domain.CodeReview;
import com.baeker.Community.post.domain.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "POST")
@RestController
@RequestMapping("${custom.mapping.post.web_pub}")
@RequiredArgsConstructor
public class PostQueryController {

    private final PostQueryUseCase postQueryUseCase;
    private final PostModifyUseCase postModifyUseCase;
    private final CodeReviewQueryUseCase codeReviewQueryUseCase;
    private final StudyPostQueryUseCase studyPostQueryUseCase;


    @Operation(summary = "post id 로 게시물 조회")
    @GetMapping("/v1/post/{postId}")
    public ResponseData<PostDto> findByPostId(
            @PathVariable Long postId
    ) {
        Post post = postQueryUseCase.byId(postId);
        postModifyUseCase.addPageView(post);
        PostDto resDto = new PostDto(post);
        return ResponseData.ok(resDto);
    }

    @Operation(summary = "problem status id 로 게시물 조회")
    @GetMapping("/v1/problem-status/{problemStatusId}")
    public ResponseData<CodeReviewDto> findByProblemStatusId(
            @PathVariable Long problemStatusId
    ) {
        CodeReview codeReview = codeReviewQueryUseCase.byProblemStatusId(problemStatusId);
        postModifyUseCase.addPageView(codeReview);
        CodeReviewDto resDto = new CodeReviewDto(codeReview);
        return ResponseData.ok(resDto);
    }

    @Operation(summary = "study id 로 게시물 조회")
    @GetMapping("/v1/study/{studyId}")
    public ResponseData<List<StudyPostDto>> findByStudyId(
            @PathVariable Long studyId
    ) {
        List<StudyPostDto> resDtos = studyPostQueryUseCase.byStudyId(studyId);
        return ResponseData.ok(resDtos);
    }


    @Operation(summary = "게시물을 추천한 회원 목록")
    @GetMapping("/v1/follower/{postId}")
    public ResponseData<List<Long>> findFollowers(
            @PathVariable Long postId
    ) {
        Post post = postQueryUseCase.byId(postId);
        return ResponseData.ok(post.getFollows());
    }

    @Operation(summary = "mission id, member id 로 코드리뷰 목록 조회")
    @GetMapping("/v1/mission/{missionId}/{memberId}")
    public ResponseData<List<CodeReviewDto>> findByMission(
            @PathVariable Long missionId,
            @PathVariable Long memberId
    ) {
        List<CodeReviewDto> resDtos = codeReviewQueryUseCase.byMission(missionId, memberId);
        return ResponseData.ok(resDtos);
    }
}
