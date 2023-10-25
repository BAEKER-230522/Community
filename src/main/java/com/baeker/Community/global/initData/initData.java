package com.baeker.Community.global.initData;

import com.baeker.Community.global.dto.reqDto.SettingChallengerDto;
import com.baeker.Community.global.dto.reqDto.SettingMissionDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Profile("dev")
@Component
@RequiredArgsConstructor
public class initData {

    private final InitService initService;

    @PostConstruct
    public void init() {
        Long missionId = 1L;

//        initService.mission1_setting(missionId);
//        initService.posting_to_mission1();
    }

    @Component
    @RequiredArgsConstructor
    static class InitService {


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

//            missionCreateUseCase.setting(reqDto);
        }

        public void posting_to_mission1() {
        }
    }
}
