package com.baeker.Community.community.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Follower {

    @Id
    private String id;

}
