package com.baeker.Community.documentGroup.domain.embedded;

import com.baeker.Community.community.domain.Category;
import com.baeker.Community.community.domain.Post;
import lombok.Data;

@Data
public class Posting {

    private String postId;
    private Long memberId;
    private Category category;
    private String title;

    public Posting(String postId, Long memberId, Category category, String title) {
        this.postId = postId;
        this.category = category;
        this.memberId = memberId;
        this.title = title;
    }
}
