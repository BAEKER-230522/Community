package com.baeker.Community.community.adapter.in.resDto;

import com.baeker.Community.community.domain.Post;
import lombok.Data;

@Data
public class PostResDto {

    private String id;
    private int pageView;

    public PostResDto(Post post) {
        this.id = post.getId();
        this.pageView = post.getPageView().getCount();
    }
}
