package com.baeker.Community.global.mongoDB;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.reqDto.SettingChallengerDto;
import com.baeker.Community.global.dto.reqDto.SettingMissionDto;
import com.baeker.Community.mission.application.prot.in.MissionCreateUseCase;
import com.baeker.Community.post.application.port.in.CodeReviewCreateUseCase;
import com.baeker.Community.post.application.port.in.CodeReviewQueryUseCase;
import com.baeker.Community.post.domain.category.CodeReview;
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
        initService.posting_to_mission1();
    }

    @Component
    @RequiredArgsConstructor
    static class InitService {

        private final MongoTemplate mongoTemplate;
        private final MissionCreateUseCase missionCreateUseCase;
        private final CodeReviewCreateUseCase postCreateUseCase;
        private final CodeReviewQueryUseCase postQueryUseCase;

        public void reset_data() {
            Set<String> collections = mongoTemplate.getCollectionNames();
            for (String collection : collections)
                mongoTemplate.remove(new Query(), collection);
        }

        public void mission1_setting(Long missionId) {
            Long problemStatusId = 1L;

            SettingMissionDto reqDto = new SettingMissionDto();
            reqDto.setMissionId(missionId);

            List<SettingChallengerDto> challengerDtos = new ArrayList<>();
            for (int i = 1; i < 3; i++) {
                SettingChallengerDto dto = new SettingChallengerDto();
                dto.setMemberId((long) i);

                List<Long> problemStatusIdList = new ArrayList<>();
                for (int j = 0; j < 2; j++) {
                    problemStatusIdList.add(problemStatusId);
                    problemStatusId++;
                }
                dto.setProblemStatusId(problemStatusIdList);
                challengerDtos.add(dto);
            }
            reqDto.setMemberList(challengerDtos);

            missionCreateUseCase.setting(reqDto);
        }

        public void posting_to_mission1() {
            CodeReview codeReview = postQueryUseCase.byProblemStatusId(1L);
            CreateCodeReviewDto reqDto = new CreateCodeReviewDto();
            reqDto.setProblemStatusId(1L);
            reqDto.setTitle("A+B");
            reqDto.setContent("import java.util.*;");
            postCreateUseCase.write(1L, reqDto, codeReview);
        }
    }
}
