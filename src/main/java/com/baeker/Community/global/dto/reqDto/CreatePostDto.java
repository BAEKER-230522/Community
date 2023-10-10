package com.baeker.Community.global.dto.reqDto;

import com.baeker.Community.comment.domain.Comments;
import com.baeker.Community.community.domain.Category;
import com.baeker.Community.community.domain.Content;
import com.baeker.Community.community.domain.Followers;
import com.baeker.Community.community.domain.PageView;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class CreatePostDto {

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
}
