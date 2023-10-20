package com.baeker.Community.category.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMission is a Querydsl query type for Mission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMission extends EntityPathBase<Mission> {

    private static final long serialVersionUID = -1810006658L;

    public static final QMission mission = new QMission("mission");

    public final com.baeker.Community.global.baseEntity.QBaseEntity _super = new com.baeker.Community.global.baseEntity.QBaseEntity(this);

    public final ListPath<CodeReview, QCodeReview> codeReviewList = this.<CodeReview, QCodeReview>createList("codeReviewList", CodeReview.class, QCodeReview.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> missionId = createNumber("missionId", Long.class);

    public QMission(String variable) {
        super(Mission.class, forVariable(variable));
    }

    public QMission(Path<? extends Mission> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMission(PathMetadata metadata) {
        super(Mission.class, metadata);
    }

}

