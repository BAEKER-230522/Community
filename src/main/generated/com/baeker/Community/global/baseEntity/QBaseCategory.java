package com.baeker.Community.global.baseEntity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBaseCategory is a Querydsl query type for BaseCategory
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseCategory extends EntityPathBase<BaseCategory> {

    private static final long serialVersionUID = 1345983890L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBaseCategory baseCategory = new QBaseCategory("baseCategory");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final com.baeker.Community.post.domain.QPost post;

    public QBaseCategory(String variable) {
        this(BaseCategory.class, forVariable(variable), INITS);
    }

    public QBaseCategory(Path<? extends BaseCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBaseCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBaseCategory(PathMetadata metadata, PathInits inits) {
        this(BaseCategory.class, metadata, inits);
    }

    public QBaseCategory(Class<? extends BaseCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new com.baeker.Community.post.domain.QPost(forProperty("post"), inits.get("post")) : null;
    }

}

