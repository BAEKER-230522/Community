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
    private Long problemStatusId;
    private Category category;
    private String title;

    public Posting(String postId, Long memberId, Category category, String title) {
        this.postId = postId;
        this.category = category;
        this.memberId = memberId;
        this.title = title;
    }

    public Posting(Long memberId, Long problemStatusId) {
        this.memberId = memberId;
        this.problemStatusId = problemStatusId;
        this.category = MISSION;
    }
}
