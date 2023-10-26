package com.baeker.Community.post.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = -1322146672L;

    public static final QPost post = new QPost("post");

    public final com.baeker.Community.global.baseEntity.QBaseEntity _super = new com.baeker.Community.global.baseEntity.QBaseEntity(this);

    public final ListPath<com.baeker.Community.comment.domain.Comment, com.baeker.Community.comment.domain.QComment> commentList = this.<com.baeker.Community.comment.domain.Comment, com.baeker.Community.comment.domain.QComment>createList("commentList", com.baeker.Community.comment.domain.Comment.class, com.baeker.Community.comment.domain.QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final ListPath<Long, NumberPath<Long>> follows = this.<Long, NumberPath<Long>>createList("follows", Long.class, NumberPath.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public final NumberPath<Integer> pageView = createNumber("pageView", Integer.class);

    public final StringPath title = createString("title");

    public QPost(String variable) {
        super(Post.class, forVariable(variable));
    }

    public QPost(Path<? extends Post> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPost(PathMetadata metadata) {
        super(Post.class, metadata);
    }

}

