package com.baeker.Community.category.application.prot.in.codeReview;

import com.baeker.Community.category.domain.CodeReview;
import com.baeker.Community.post.domain.Post;

public interface CodeReviewModifyUseCase {

    void write(CodeReview codeReview, Post post);
}
