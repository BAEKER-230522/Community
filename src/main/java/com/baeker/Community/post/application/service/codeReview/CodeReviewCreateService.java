package com.baeker.Community.post.application.service.codeReview;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.member.application.in.MemberModifyUseCase;
import com.baeker.Community.post.application.port.in.codeReview.CodeReviewCreateUseCase;
import com.baeker.Community.post.application.port.out.CodeReviewRepositoryPort;
import com.baeker.Community.post.domain.category.CodeReview;
import com.baeker.Community.post.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CodeReviewCreateService implements CodeReviewCreateUseCase {

    private final CodeReviewRepositoryPort repository;
    private final MemberModifyUseCase memberModifyUseCase;

    @Override
    public CodeReview setting(Long problemStatusId) {
        return repository.save(
                CodeReview.setting(problemStatusId)
        );
    }

    @Override
    public CodeReviewDto write(Long memberId, CreateCodeReviewDto dto, CodeReview codeReview) {
        Post post = Post.create(memberId, dto);
        CodeReview write = codeReview.write(post);
        CodeReview updateCodeReview = repository.save(write);

        memberModifyUseCase.posting(memberId, updateCodeReview);
        return new CodeReviewDto(updateCodeReview);
    }
}
