package com.baeker.Community.post.domain.category;

import com.baeker.Community.post.domain.post.Followers;
import com.baeker.Community.post.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Document
@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class CodeReview {

    @Id
    private String id;
    private Long problemStatusId;
    private String title;

    @Field
    private Post post;


    public CodeReview write(Post post) {
        return this.toBuilder()
                .post(post)
                .title(post.getTitle())
                .build();
    }

    public static CodeReview setting(Long problemStatusId) {
        return CodeReview.builder()
                .problemStatusId(problemStatusId)
                .build();
    }

    public void modifyFollow(Followers followers) {
        this.post.modifyFollow(followers);
    }

    public List<Long> getFollowers() {
        return this.getPost()
                .getFollowers()
                .getMemberList();
    }

    public int getFollowerCount() {
        return this.getFollowers().size();
    }

    public int getPageViews() {
        return this.getPost()
                .getPageView()
                .getCount();
    }

    public int getCommentCount() {
        return this.getPost()
                .getCommentList()
                .size();
    }
}