package com.baeker.Community.global.dto.reqDto;

import com.baeker.Community.comment.domain.Comments;
import com.baeker.Community.post.domain.post.Category;
import com.baeker.Community.post.domain.post.Content;
import com.baeker.Community.post.domain.post.Followers;
import com.baeker.Community.post.domain.post.PageView;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class CreatePostDto {

    private Long missionId;
    private Long personalId;
    private String title;
    private String body;

    @Null
    private Category category;
    @Null
    private Content content;
    @Null
    private Comments comments;
    @Null
    private PageView pageView;
    @Null
    private Followers followers;

    public void setting(Category category, Content content, Comments comments, PageView pageView, Followers followers) {
        this.category = category;
        this.content = content;
        this.comments = comments;
        this.pageView = pageView;
        this.followers = followers;
    }
}
