package com.baeker.Community.global.testUtil;

import com.baeker.Community.comment.application.port.in.CommentCreateUSeCase;
import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.reqDto.CreateStudyPostDto;
import com.baeker.Community.post.application.port.in.post.PostCreateUseCase;
import com.baeker.Community.post.application.port.in.post.PostModifyUseCase;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import com.baeker.Community.post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateObject {

    @Autowired
    private PostCreateUseCase postCreateUseCase;
    @Autowired
    private PostQueryUseCase postQueryUseCase;
    @Autowired
    private PostModifyUseCase postModifyUseCase;
    @Autowired
    private CommentCreateUSeCase commentCreateUSeCase;

    public Long studyPost(Long memberId, Long studyId, int title) {
        CreateStudyPostDto dto = new CreateStudyPostDto(studyId, "post" + title, "content");
        return postCreateUseCase.studyPost(memberId, dto).getPostId();
    }

    public Long studyPost(Long memberId, int title) {
        CreateStudyPostDto dto = new CreateStudyPostDto(1L, "post" + title, "content");
        return postCreateUseCase.studyPost(memberId, dto).getPostId();
    }

    public Long codeReview(Long memberId, Long missionId, Long problemStatusId, int title) {
        CreateCodeReviewDto dto = new CreateCodeReviewDto(1L, missionId, problemStatusId, "post" + title, "content");
        return postCreateUseCase.codeReview(memberId, dto).getPostId();
    }

    public Long codeReview(Long memberId) {
        CreateCodeReviewDto dto = new CreateCodeReviewDto(1L, 1L, 1L, "post1", "content");
        return postCreateUseCase.codeReview(memberId, dto).getPostId();
    }

    public Long codeReview() {
        CreateCodeReviewDto dto = new CreateCodeReviewDto(1L, 1L, 1L, "post1", "content");
        return postCreateUseCase.codeReview(1L, dto).getPostId();
    }

    public void follow(Long memberId, Long postId) {
        Post post = postQueryUseCase.byId(postId);
        postModifyUseCase.follow(memberId, post);
    }

    public Long comment(Long memberId, Long postId) {
        Post post = postQueryUseCase.byId(postId);
        return commentCreateUSeCase.write(memberId, post, "comment").getCommentId();
    }
}
