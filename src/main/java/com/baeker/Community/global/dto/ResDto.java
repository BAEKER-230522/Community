package com.baeker.Community.global.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResDto<T> {

    private T data;

    public static <T> ResDto<T> of(T data) {
        return new ResDto<>(data);
    }
}
