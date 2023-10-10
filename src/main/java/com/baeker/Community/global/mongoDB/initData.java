package com.baeker.Community.global.mongoDB;

import com.baeker.Community.community.application.port.in.pageView.PageViewDeleteUseCase;
import com.baeker.Community.community.application.port.in.post.PostDeleteUseCase;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Profile("dev")
@Component
@RequiredArgsConstructor
public class initData {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.resetData();
    }

    @Component
    @RequiredArgsConstructor
    static class InitService{

        private final MongoTemplate mongoTemplate;


        public void resetData() {
            ArrayList<String> collections = new ArrayList<>();
            collections.add("post");
            collections.add("pageView");

            for (String collection : collections)
                deleteData(collection);
        }

        private void deleteData(String collection) {
            mongoTemplate.remove(new Query(), collection);
        }
    }

}
