package com.baeker.Community.community.application.service.post;

import com.baeker.Community.comment.domain.Comments;
import com.baeker.Community.community.application.port.in.post.PostCreateUseCase;
import com.baeker.Community.community.domain.Content;
import com.baeker.Community.community.domain.Followers;
import com.baeker.Community.community.domain.PageView;
import com.baeker.Community.community.domain.Post;
import com.baeker.Community.documentGroup.application.in.member.MemberModifyUseCase;
import com.baeker.Community.documentGroup.application.in.member.MemberQueryUseCase;
import com.baeker.Community.documentGroup.domain.Member;
import com.baeker.Community.documentGroup.domain.embedded.Posting;
import com.baeker.Community.global.dto.reqDto.CreatePostDto;
import com.baeker.Community.global.dto.resDto.PostResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.baeker.Community.community.domain.Category.MISSION;

@Service
@Transactional
@RequiredArgsConstructor
public class PostCreateService implements PostCreateUseCase {

    private final MongoTemplate repository;
    private final MemberModifyUseCase memberModifyUseCase;

    @Override
    public PostResDto Mission(Long memberId, CreatePostDto dto) {
        dto.setting(MISSION,
                repository.save(Content.create(dto)),
                repository.save(Comments.create()),
                repository.save(PageView.create()),
                repository.save(Followers.create())
        );

        Post post = repository.save(
                Post.create(memberId, dto));

        updateMember(memberId, post);
        return new PostResDto(post);
    }

    private void updateMember(Long memberId, Post post) {
        Posting posting = new Posting(post);
        memberModifyUseCase.posting(memberId, posting);
    }
}
