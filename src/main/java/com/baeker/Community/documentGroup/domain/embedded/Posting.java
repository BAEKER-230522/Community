package com.baeker.Community.documentGroup.domain.embedded;

import com.baeker.Community.community.domain.Post;
import lombok.Data;

@Data
public class Posting {

    private String PostId;
    private Long memberId;
    private String title;

    public Posting(Post post) {
        PostId = post.getId();
        this.memberId = post.getMemberId();
        this.title = post.getContent().getTitle();
    }
}
