package com.baeker.Community.global.jwt;

public class InvalidJwtException extends RuntimeException {

    public InvalidJwtException(String msg) {
        super(msg);
    }
}
