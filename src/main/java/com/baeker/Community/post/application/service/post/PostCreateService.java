package com.baeker.Community.post.application.service.post;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.comment.domain.Comments;
import com.baeker.Community.member.application.in.member.MemberModifyUseCase;
import com.baeker.Community.member.domain.embedded.Posting;
import com.baeker.Community.global.dto.reqDto.CreatePostDto;
import com.baeker.Community.global.dto.resDto.PostResDto;
import com.baeker.Community.post.application.port.in.post.PostCreateUseCase;
import com.baeker.Community.post.application.port.in.posts.PostsModifyUseCase;
import com.baeker.Community.post.domain.post.Content;
import com.baeker.Community.post.domain.post.Followers;
import com.baeker.Community.post.domain.post.PageView;
import com.baeker.Community.post.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.baeker.Community.post.domain.post.Category.MISSION;

@Service
@Transactional
@RequiredArgsConstructor
public class PostCreateService implements PostCreateUseCase {

    private final MongoTemplate mongoTemplate;
    private final MemberModifyUseCase memberModifyUseCase;
    private final PostsModifyUseCase postsModifyUseCase;

    @Override
    public PostResDto Mission(Long memberId, CreatePostDto dto) {

        // mission 에 title 값으로 해당 문제가 있는지 확인해야 함

        dto.setting(MISSION,
                mongoTemplate.save(Content.create(dto)),
                mongoTemplate.save(Comments.create()),
                mongoTemplate.save(PageView.create()),
                mongoTemplate.save(Followers.create())
        );

        Post post = mongoTemplate.save(
                Post.createMission(memberId, dto));

        updatePostingGroup(memberId, dto.getMissionId(), post);
        return new PostResDto(post, getComments(post.getComments()));
    }


    private void updatePostingGroup(Long memberId, Long missionId, Post post) {
        Posting posting = new Posting(post.getId(), memberId, post.getCategory(),post.getContent().getTitle());
        memberModifyUseCase.posting(memberId, posting);
        postsModifyUseCase.posting(memberId, missionId, posting);
    }

    private List<Comment> getComments(Comments comments) {
        List<String> commentList = comments.getComments();
        Query query = new Query(Criteria.where("id").is(commentList));
        return mongoTemplate.find(query, Comment.class);
    }
}
