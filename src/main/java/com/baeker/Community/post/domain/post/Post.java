package com.baeker.Community.post.domain.post;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.post.domain.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.baeker.Community.post.domain.category.Category.CODE_REVIEW;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Document
@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Post {

    @Id
    private String id;
    private Long memberId;
    private Long problemStatusId;
    private LocalDateTime createDate;
    private Category category;
    private String title;
    private String content;

    @Field
    private PageView pageView;
    @Field
    private Followers followers;

    @DBRef
    @Builder.Default
    private List<Comment> commentList = new ArrayList<>();


    public static Post settingMission(Long problemStatusId) {
        return Post.builder()
                .problemStatusId(problemStatusId)
                .category(CODE_REVIEW)
                .build();
    }

    public Post write(Long memberId, CreateCodeReviewDto dto) {
        return this.toBuilder()
                .memberId(memberId)
                .createDate(LocalDateTime.now())
                .title(dto.getTitle())
                .content(dto.getContent())
                .pageView(PageView.create())
                .followers(Followers.create())
                .build();
    }

    public void modifyFollow(Followers followers) {
        this.toBuilder()
                .followers(followers)
                .build();
    }

    public List<Long> getFollowList() {
        return this.getFollowers()
                .getMemberList();
    }

    public int getPageViewCount() {
        return this.getPageView()
                .getCount();
    }

    public int getFollowCount() {
        return this.getFollowList()
                .size();
    }
}
