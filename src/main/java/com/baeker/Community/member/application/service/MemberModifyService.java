package com.baeker.Community.member.application.service;

import com.baeker.Community.member.application.in.MemberModifyUseCase;
import com.baeker.Community.member.application.in.MemberQueryUseCase;
import com.baeker.Community.member.application.out.MemberRepositoryPort;
import com.baeker.Community.member.domain.Member;
import com.baeker.Community.post.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberModifyService implements MemberModifyUseCase {

    private final MemberRepositoryPort repository;

    @Override
    public void follow(Member member, Post post) {
        member.followContent(post);
        repository.save(member);
    }

    @Override
    public void unfollow(Member member, Post post) {
        member.unfollow(post);
        repository.save(member);
    }
}
