package com.baeker.Community.comment.application.service.comment;

import com.baeker.Community.comment.application.port.in.comment.CommentQueryUseCase;
import com.baeker.Community.comment.domain.Comment;
import com.baeker.Community.post.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentQueryService implements CommentQueryUseCase {

    private final MongoTemplate mongoTemplate;


    @Override
    public List<Comment> byPost(Post post) {
//        List<String> comments = post.getComments().getComments();
//        Query query = new Query(Criteria.where("id").is(comments));
//        return mongoTemplate.find(query, Comment.class);
        return null;
    }
}
