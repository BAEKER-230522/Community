package com.baeker.Community.post.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudyPost is a Querydsl query type for StudyPost
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudyPost extends EntityPathBase<StudyPost> {

    private static final long serialVersionUID = 1332738073L;

    public static final QStudyPost studyPost = new QStudyPost("studyPost");

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

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    //inherited
    public final NumberPath<Integer> pageView = _super.pageView;

    public final NumberPath<Long> studyId = createNumber("studyId", Long.class);

    //inherited
    public final StringPath title = _super.title;

    public QStudyPost(String variable) {
        super(StudyPost.class, forVariable(variable));
    }

    public QStudyPost(Path<? extends StudyPost> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudyPost(PathMetadata metadata) {
        super(StudyPost.class, metadata);
    }

}

