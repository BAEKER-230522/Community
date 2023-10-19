package com.baeker.Community.global.initData;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.reqDto.SettingChallengerDto;
import com.baeker.Community.global.dto.reqDto.SettingMissionDto;
import com.baeker.Community.category.application.prot.in.CodeReview.CodeReviewCreateUseCase;
import com.baeker.Community.post.application.port.in.PostModifyUseCase;
import com.baeker.Community.post.application.port.in.PostQueryUseCase;
import com.baeker.Community.post.domain.Post;
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
        private final CodeReviewCreateUseCase missionCreateUseCase;
        private final PostModifyUseCase postModifyUseCase;
        private final PostQueryUseCase postQueryUseCase;

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
                dto.setProblemStatusIdList(problemStatusIdList);
                challengerDtos.add(dto);
            }
            reqDto.setMemberList(challengerDtos);

            missionCreateUseCase.setting(reqDto);
        }

        public void posting_to_mission1() {
            Post post = postQueryUseCase.byProblemStatusId(1L);
            CreateCodeReviewDto reqDto = new CreateCodeReviewDto();
            reqDto.setProblemStatusId(1L);
            reqDto.setTitle("A+B");
            reqDto.setContent("import java.util.*;");
            postModifyUseCase.write(1L, reqDto, post);
        }
    }
}
