package com.baeker.Community.post.application.service.post;

import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.comment.domain.Comments;
import com.baeker.Community.global.dto.resDto.PostResDto;
import com.baeker.Community.global.exception.service.NotFoundException;
import com.baeker.Community.post.application.port.in.post.PostQueryUseCase;
import com.baeker.Community.post.application.port.out.PostRepositoryPort;
import com.baeker.Community.post.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostQueryService implements PostQueryUseCase {

    private final PostRepositoryPort repository;
    private final MongoTemplate mongoTemplate;


    @Override
    public Post byId(String postId) {
        Optional<Post> byId = repository.findById(postId);

        if (!byId.isPresent())
            throw new NotFoundException("존재하지 않는 게시물");

        return byId.get();
    }

    @Override
    public PostResDto byPersonalId(Long personalId) {
        Optional<Post> byPersonalId = repository.findByPersonalId(personalId);

        if (!byPersonalId.isPresent())
            throw new NotFoundException("존재하지 않는 게시물");

        Post post = byPersonalId.get();
        return new PostResDto(post, getComments(post.getComments()));
    }

    private List<Comment> getComments(Comments comments) {
        List<String> commentList = comments.getComments();
        Query query = new Query(Criteria.where("id").is(commentList));
        return mongoTemplate.find(query, Comment.class);
    }
}
