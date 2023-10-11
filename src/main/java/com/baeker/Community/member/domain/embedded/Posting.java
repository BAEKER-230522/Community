package com.baeker.Community.member.domain.embedded;

import com.baeker.Community.post.domain.post.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.baeker.Community.post.domain.post.Category.MISSION;

@Data
@NoArgsConstructor
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

    public Posting(Long memberId, String title) {
        this.memberId = memberId;
        this.title = title;
        this.category = MISSION;
    }
}
