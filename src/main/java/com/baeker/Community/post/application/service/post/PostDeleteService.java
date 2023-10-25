package com.baeker.Community.post.application.service.post;

import com.baeker.Community.post.application.port.in.post.PostDeleteUseCase;
import com.baeker.Community.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostDeleteService implements PostDeleteUseCase {


    @Override
    public void post(Post post) {

    }
}
