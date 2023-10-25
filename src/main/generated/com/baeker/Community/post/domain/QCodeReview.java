package com.baeker.Community.post.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCodeReview is a Querydsl query type for CodeReview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCodeReview extends EntityPathBase<CodeReview> {

    private static final long serialVersionUID = -2110651499L;

    public static final QCodeReview codeReview = new QCodeReview("codeReview");

    public final QPost _super = new QPost(this);

    //inherited
    public final ListPath<com.baeker.Community.comment.domain.Comment, com.baeker.Community.comment.domain.QComment> commentList = _super.commentList;

    //inherited
    public final StringPath content = _super.content;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    //inherited
    public final ListPath<Long, NumberPath<Long>> follows = _super.follows;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final NumberPath<Long> memberId = _super.memberId;

    public final NumberPath<Long> missionId = createNumber("missionId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    //inherited
    public final NumberPath<Integer> pageView = _super.pageView;

    public final NumberPath<Long> problemStatusId = createNumber("problemStatusId", Long.class);

    //inherited
    public final StringPath title = _super.title;

    public QCodeReview(String variable) {
        super(CodeReview.class, forVariable(variable));
    }

    public QCodeReview(Path<? extends CodeReview> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCodeReview(PathMetadata metadata) {
        super(CodeReview.class, metadata);
    }

}

