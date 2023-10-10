package com.baeker.Community.community.application.service.pageView;

import com.baeker.Community.community.application.port.in.pageView.PageViewDeleteUseCase;
import com.baeker.Community.community.domain.PageView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PageViewDeleteService implements PageViewDeleteUseCase {


    @Override
    public void pageView(PageView pageView) {

    }
}
