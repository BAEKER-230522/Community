package com.baeker.Community.comment.adapter.in.web;

import com.baeker.Community.comment.application.port.in.CommentModifyUseCase;
import com.baeker.Community.comment.application.port.in.CommentQueryUseCase;
import com.baeker.Community.global.jwt.JwtDecrypt;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "COMMENT")
@RestController
@RequestMapping("${custom.mapping.comment.web_usr}")
@RequiredArgsConstructor
public class CommentModifyController {

    private final CommentQueryUseCase commentQueryUseCase;
    private final CommentModifyUseCase commentModifyUseCase;
    private final JwtDecrypt decrypt;

}
