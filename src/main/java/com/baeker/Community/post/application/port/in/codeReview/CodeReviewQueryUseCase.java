package com.baeker.Community.post.application.port.in.codeReview;

import com.baeker.Community.global.dto.resDto.ChallengerResDto;
import com.baeker.Community.mission.domain.Challenger;
import com.baeker.Community.post.domain.category.CodeReview;
import com.baeker.Community.post.domain.post.Post;

import java.util.List;

public interface CodeReviewQueryUseCase {

    CodeReview byId(String postId);


    CodeReview byProblemStatusId(Long problemStatusId);
}
