package com.baeker.Community.post.application.port.out.feign;

import com.baeker.Community.global.appConfig.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "study", url = "${custom.feign.study}", configuration = FeignConfiguration.class)
public interface StudyClientPort {
}
