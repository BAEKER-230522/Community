package com.baeker.Community.post.application.port.out.feign;

import com.baeker.Community.global.appConfig.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "study", url = "${custom.feign.study}", configuration = FeignConfiguration.class)
public interface StudyClientPort {


    @GetMapping("/v1/member/{memberId}/{studyId}")
    ResponseEntity isMember(
            @PathVariable("memberId") Long memberId,
            @PathVariable("studyId") Long studyId
    );
}
