package com.baeker.Community.member.application.in;

import com.baeker.Community.global.dto.resDto.PostDto;
import com.baeker.Community.member.domain.Member;

import java.util.List;

public interface MemberQueryUseCase {

    Member byMemberId(Long memberId);
}
