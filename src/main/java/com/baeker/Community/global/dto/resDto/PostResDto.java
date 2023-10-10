package com.baeker.Community.global.dto.resDto;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.comment.domain.Comments;
import com.baeker.Community.post.domain.Category;
import com.baeker.Community.post.domain.Content;
import com.baeker.Community.post.domain.Followers;
import com.baeker.Community.post.domain.Post;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PostResDto {

    private String id;
    private Long memberId;
    private Long personalId;
    private LocalDateTime createDate;

    private Category category;
    private int pageView;
    private int follower;

    private Content content;
    private List<Comment> comments;

    public PostResDto(Post post, List<Comment> comments) {
        this.id = post.getId();
        this.memberId = post.getMemberId();
        this.personalId = post.getPersonalId();
        this.createDate = post.getCreateDate();
        this.category = post.getCategory();
        this.pageView = post.getPageView().getCount();
        this.follower = post.getFollowers().getFollowerList().size();
        this.content = post.getContent();
        this.comments = comments;
    }
}
