package com.baeker.Community.global.exception.controller;

import com.baeker.Community.global.jwt.InvalidJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(InvalidJwtException.class)
    public ResponseEntity<ErrorResponse> invalidJwtExceptionHandler(InvalidJwtException e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
    }
}