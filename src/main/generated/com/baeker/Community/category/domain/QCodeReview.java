package com.baeker.Community.category.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCodeReview is a Querydsl query type for CodeReview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCodeReview extends EntityPathBase<CodeReview> {

    private static final long serialVersionUID = 536531571L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCodeReview codeReview = new QCodeReview("codeReview");

    public final com.baeker.Community.global.baseEntity.QBaseCategory _super;

    //inherited
    public final NumberPath<Long> id;

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final QMission mission;

    // inherited
    public final com.baeker.Community.post.domain.QPost post;

    public final NumberPath<Long> problemStatusId = createNumber("problemStatusId", Long.class);

    public QCodeReview(String variable) {
        this(CodeReview.class, forVariable(variable), INITS);
    }

    public QCodeReview(Path<? extends CodeReview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCodeReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCodeReview(PathMetadata metadata, PathInits inits) {
        this(CodeReview.class, metadata, inits);
    }

    public QCodeReview(Class<? extends CodeReview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.baeker.Community.global.baseEntity.QBaseCategory(type, metadata, inits);
        this.id = _super.id;
        this.mission = inits.isInitialized("mission") ? new QMission(forProperty("mission")) : null;
        this.post = _super.post;
    }

}

