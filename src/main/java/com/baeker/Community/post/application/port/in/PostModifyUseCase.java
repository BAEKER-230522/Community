package com.baeker.Community.post.application.port.in;

import com.baeker.Community.category.domain.CodeReview;
import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.member.domain.Member;
import com.baeker.Community.post.domain.Post;

public interface PostModifyUseCase {

    CodeReviewDto write(Long memberId, CreateCodeReviewDto dto, CodeReview codeReview);

    void follow(Member member, Post post);

    void addComment(Post post, Comment comment);
}
