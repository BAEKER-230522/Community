package com.baeker.Community.global.mongoDB;

import com.baeker.Community.global.dto.reqDto.CreatePostDto;
import com.baeker.Community.global.dto.reqDto.CreatePostsReqDto;
import com.baeker.Community.mission.application.prot.in.MissionCreateUseCase;
import com.baeker.Community.mission.application.prot.in.MissionQueryUseCase;
import com.baeker.Community.mission.domain.Mission;
import com.baeker.Community.post.application.port.in.PostCreateUseCase;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Profile("dev")
@Component
@RequiredArgsConstructor
public class initData {

    private final InitService initService;

    @PostConstruct
    public void init() {
        Long missionId = 1L;

        initService.reset_data();
        initService.mission1_setting(missionId);
        initService.posting_to_mission1(missionId);
    }

    @Component
    @RequiredArgsConstructor
    static class InitService{

        private final MongoTemplate mongoTemplate;
        private final MissionCreateUseCase missionCreateUseCase;
        private final MissionQueryUseCase missionQueryUseCase;
        private final PostCreateUseCase postCreateUseCase;

        public void reset_data() {
            Set<String> collections = mongoTemplate.getCollectionNames();
            for (String collection : collections)
                mongoTemplate.remove(new Query(), collection);
        }

        public void mission1_setting(Long missionId) {
            List<Long> memberIdList = new ArrayList<>();
            List<Long> titleList = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                memberIdList.add((long) (i + 1));
                titleList.add((long) (i + 1));
            }

            CreatePostsReqDto reqDto = new CreatePostsReqDto(missionId, memberIdList, titleList);
            missionCreateUseCase.setting(reqDto);
        }

        public void posting_to_mission1(Long missionId) {
            Mission mission = missionQueryUseCase.byMissionId(missionId);

            CreatePostDto reqDto = new CreatePostDto();
            reqDto.setMissionId(missionId);
            reqDto.setProblemStatusId(1L);
            reqDto.setTitle("A+B");
            reqDto.setContent("import java.util.*;");
            postCreateUseCase.mission(1L, reqDto, mission);
        }
    }
}
