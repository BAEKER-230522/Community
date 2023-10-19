package com.baeker.Community.global.baseEntity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseComm is a Querydsl query type for BaseComm
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseComm extends EntityPathBase<BaseComm> {

    private static final long serialVersionUID = -2005831264L;

    public static final QBaseComm baseComm = new QBaseComm("baseComm");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.time.LocalDateTime> modifyDate = createDateTime("modifyDate", java.time.LocalDateTime.class);

    public QBaseComm(String variable) {
        super(BaseComm.class, forVariable(variable));
    }

    public QBaseComm(Path<? extends BaseComm> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseComm(PathMetadata metadata) {
        super(BaseComm.class, metadata);
    }

}

