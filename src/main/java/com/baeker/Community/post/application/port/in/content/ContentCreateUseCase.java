package com.baeker.Community.post.application.port.in.content;

import com.baeker.Community.post.domain.Content;

public interface ContentCreateUseCase {

    Content content(String title, String body);
}
