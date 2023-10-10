package com.baeker.Community.community.application.port.out;

import com.baeker.Community.community.domain.PageView;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PageViewRepositoryPort extends MongoRepository<PageView, String> {

}
