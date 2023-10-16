package com.baeker.Community.post.application.service;

import com.baeker.Community.global.dto.reqDto.CreatePostDto;
import com.baeker.Community.global.dto.resDto.CodeReviewResDto;
import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.member.application.in.MemberModifyUseCase;
import com.baeker.Community.mission.application.prot.in.MissionModifyUseCase;
import com.baeker.Community.mission.domain.Mission;
import com.baeker.Community.post.application.port.in.PostCreateUseCase;
import com.baeker.Community.post.application.port.out.PostRepositoryPort;
import com.baeker.Community.post.domain.category.CodeReview;
import com.baeker.Community.post.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostCreateService implements PostCreateUseCase {

    private final PostRepositoryPort repository;
    private final MemberModifyUseCase memberModifyUseCase;
    private final MissionModifyUseCase missionModifyUseCase;

    @Override
    public CodeReviewResDto mission(Long memberId, CreatePostDto dto, Mission mission) {
        CodeReview codeReview = getCodeReview(memberId, dto.getProblemStatusId(), mission);

        Post post = repository.save(
                Post.create(memberId, dto));
        codeReview.write(post);

        missionModifyUseCase.write(mission);
        memberModifyUseCase.posting(memberId, codeReview);
        return new CodeReviewResDto(post, dto.getProblemStatusId());
    }


    private CodeReview getCodeReview(Long memberId, Long problemStatusId, Mission mission) {
        CodeReview codeReview = mission.getCodeReview(memberId, problemStatusId);

        if (codeReview == null)
            throw new NotFoundException("존재하지 않는 게시물");

        return codeReview;
    }
}
