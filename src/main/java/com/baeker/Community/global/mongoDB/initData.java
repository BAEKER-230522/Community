package com.baeker.Community.global.mongoDB;

import com.baeker.Community.global.dto.reqDto.CreatePostDto;
import com.baeker.Community.global.dto.reqDto.CreatePostsReqDto;
import com.baeker.Community.post.application.port.in.post.PostCreateUseCase;
import com.baeker.Community.post.application.port.in.posts.PostsCreateUseCase;
import com.baeker.Community.post.domain.post.Category;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.baeker.Community.post.domain.post.Category.MISSION;

@Profile("dev")
@Component
@RequiredArgsConstructor
public class initData {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.reset_data();
        initService.posts1_setting();
        initService.mission_post_posting();
    }

    @Component
    @RequiredArgsConstructor
    static class InitService{

        private final MongoTemplate mongoTemplate;
        private final PostsCreateUseCase postsCreateUseCase;
        private final PostCreateUseCase postCreateUseCase;

        public void reset_data() {
            Set<String> collections = mongoTemplate.getCollectionNames();
            for (String collection : collections)
                mongoTemplate.remove(new Query(), collection);
        }

        public void posts1_setting() {
            List<Long> memberIdList = new ArrayList<>();
            List<String> titleList = new ArrayList<>();

            String[] titles = {"A+B", "A-B"};
            for (int i = 0; i < titles.length; i++) {
                memberIdList.add((long) (i + 1));
                titleList.add(titles[i]);
            }

            CreatePostsReqDto reqDto = new CreatePostsReqDto(1L, memberIdList, titleList);
            postsCreateUseCase.setting(reqDto);
        }

        public void mission_post_posting() {
            CreatePostDto reqDto = new CreatePostDto();
            reqDto.setMissionId(1L);
            reqDto.setPersonalId(1L);
            reqDto.setTitle("A+B");
            reqDto.setBody("import java.util.*;");
            postCreateUseCase.Mission(1L, reqDto);
        }
    }
}
