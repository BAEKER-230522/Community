package com.baeker.Community.community.application.service.pageView;

import com.baeker.Community.community.application.port.in.pageView.PageViewUserCase;
import com.baeker.Community.community.application.port.out.PageViewRepositoryPort;
import com.baeker.Community.community.domain.PageView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PageViewService implements PageViewUserCase {

    private final PageViewRepositoryPort repository;

    @Override
    public PageView create() {
        PageView pageView = PageView.create();
        return repository.save(pageView);
    }
}
