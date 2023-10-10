package com.baeker.Community.community.application.port.in.content;

import com.baeker.Community.community.domain.Content;

public interface ContentCreateUseCase {

    Content content(String title, String body);
}
