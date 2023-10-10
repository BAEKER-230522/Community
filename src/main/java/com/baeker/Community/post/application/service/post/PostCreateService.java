package com.baeker.Community.post.application.service.post;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.comment.domain.Comments;
import com.baeker.Community.documentGroup.application.in.member.MemberModifyUseCase;
import com.baeker.Community.documentGroup.domain.embedded.Posting;
import com.baeker.Community.global.dto.reqDto.CreatePostDto;
import com.baeker.Community.global.dto.resDto.PostResDto;
import com.baeker.Community.post.application.port.in.post.PostCreateUseCase;
import com.baeker.Community.post.domain.Content;
import com.baeker.Community.post.domain.Followers;
import com.baeker.Community.post.domain.PageView;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.baeker.Community.post.domain.Category.MISSION;

@Service
@Transactional
@RequiredArgsConstructor
public class PostCreateService implements PostCreateUseCase {

    private final MongoTemplate repository;
    private final MemberModifyUseCase memberModifyUseCase;

    @Override
    public PostResDto Mission(Long memberId, CreatePostDto dto) {
        dto.setting(MISSION,
                repository.save(Content.create(dto)),
                repository.save(Comments.create()),
                repository.save(PageView.create()),
                repository.save(Followers.create())
        );

        Post post = repository.save(
                Post.createMission(memberId, dto));

        updateMember(memberId, post);
        return new PostResDto(post, getComments(post.getComments()));
    }


    private void updateMember(Long memberId, Post post) {
        Posting posting = new Posting(post.getId(), memberId, post.getCategory(),post.getContent().getTitle());
        memberModifyUseCase.posting(memberId, posting);
    }

    private List<Comment> getComments(Comments comments) {
        List<String> commentList = comments.getComments();
        Query query = new Query(Criteria.where("id").is(commentList));
        return repository.find(query, Comment.class);
    }
}
