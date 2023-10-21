package com.baeker.Community.global.testUtil;

import org.springframework.beans.factory.annotation.Value;

public class TestData {

    @Value("${custom.mapping.post.web_pub}")
    public String POST_PUBLIC_URL;

    @Value("${custom.mapping.post.web_usr}")
    public String POST_USER_URL;

    @Value("${custom.mapping.mission.web_pub}")
    public String MISSION_PUBLIC_URL;

    @Value("${custom.mapping.comment.web_usr}")
    public String COMMENT_USER_URL;


    @Value("${custom.jwt.test1}")
    public String jwt1;

    @Value("${custom.jwt.test2}")
    public String jwt2;

    @Value("${custom.jwt.test3}")
    public String jwt3;
}
