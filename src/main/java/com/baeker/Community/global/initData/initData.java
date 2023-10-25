package com.baeker.Community.global.initData;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

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
        }

        public void posting_to_mission1() {
        }
    }
}
