package com.baeker.Community.global.appConfig;

import com.baeker.Community.global.exception.controller.FeignErrorDecode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public FeignErrorDecode feignErrorDecode() {
        return new FeignErrorDecode();
    }
}