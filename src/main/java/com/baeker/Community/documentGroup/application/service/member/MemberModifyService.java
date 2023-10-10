package com.baeker.Community.documentGroup.application.service.member;

import com.baeker.Community.documentGroup.application.in.member.MemberCreateUseCase;
import com.baeker.Community.documentGroup.application.in.member.MemberModifyUseCase;
import com.baeker.Community.documentGroup.application.in.member.MemberQueryUseCase;
import com.baeker.Community.documentGroup.domain.Member;
import com.baeker.Community.documentGroup.domain.embedded.Posting;
import com.baeker.Community.global.exception.service.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberModifyService implements MemberModifyUseCase {

    private final MemberCreateUseCase memberCreateUseCase;
    private final MemberQueryUseCase memberQueryUseCase;

    @Override
    public void posting(Long memberId, Posting posting) {
        Member member = getMember(memberId);

        if (member.getPostings() == null)
            member = memberCreateUseCase.setting(member.getMemberId());

        member.writePost(posting);
    }

    private Member getMember(Long memberId) {
        try {
            return memberQueryUseCase.byMemberId(memberId);
        } catch (NotFoundException e) {
            return memberCreateUseCase.setting(memberId);
        }
    }
}
