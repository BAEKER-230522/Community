package com.baeker.Community.global.exception.jwt;

public class InvalidJwtException extends RuntimeException {

    public InvalidJwtException(String msg) {
        super(msg);
    }
}
