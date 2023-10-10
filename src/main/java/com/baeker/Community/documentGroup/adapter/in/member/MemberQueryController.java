package com.baeker.Community.documentGroup.adapter.in.member;

import com.baeker.Community.documentGroup.application.in.member.MemberQueryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${custom.mapping.member.web}")
@RequiredArgsConstructor
public class MemberQueryController {

    private final MemberQueryUseCase memberQueryUseCase;

}
