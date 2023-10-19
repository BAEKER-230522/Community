package com.baeker.Community.global.baseEntity;

import com.baeker.Community.post.domain.Post;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.FetchType.LAZY;

@MappedSuperclass
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class BaseCategory extends BaseEntity {

    @OneToOne(fetch = LAZY)
    private Post post;
}
