package com.baeker.Community.member.domain;

import com.baeker.Community.post.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Following {

    @DBRef
    @Builder.Default
    private List<Post> codeReviewList = new ArrayList<>();

    protected void follow(Post post) {
        this.codeReviewList.add(post);
    }

    protected void unfollow(Post post) {
        this.codeReviewList.remove(post);
    }
}
