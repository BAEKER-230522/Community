package com.baeker.Community.community.application.service.post;

import com.baeker.Community.comment.domain.Comments;
import com.baeker.Community.community.domain.Content;
import com.baeker.Community.community.domain.Followers;
import com.baeker.Community.community.domain.PageView;
import com.baeker.Community.global.dto.reqDto.CreatePostDto;
import com.baeker.Community.global.dto.resDto.PostResDto;
import com.baeker.Community.community.application.port.in.post.PostCreateUseCase;
import com.baeker.Community.community.domain.Post;
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


    @Override
    public PostResDto post(Long memberId, CreatePostDto dto) {
        dto.setCategory(MISSION);

        dto.setPageView(repository.save(PageView.create()));
        dto.setContent(repository.save(Content.create(dto)));
        dto.setComments(repository.save(Comments.create()));
        dto.setFollowers(repository.save(Followers.create()));

        Post post = repository.save(
                Post.create(memberId, dto));
        return new PostResDto(post);
    }
}
