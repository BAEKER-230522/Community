package com.baeker.Community.global.dto;

import com.baeker.Community.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseData<T> {

    private T data;

    public static  <T> ResponseData<T> noContent() {
        return new ResponseData<>((T) "200 OK");
    }

    public static <T> ResponseData<T> ok(T data) {
        return new ResponseData<>(data);
    }
}
