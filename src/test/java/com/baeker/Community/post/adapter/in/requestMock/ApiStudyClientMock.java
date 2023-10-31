package com.baeker.Community.post.adapter.in.requestMock;

import com.baeker.Community.global.exception.feign.FeignClientException;
import com.baeker.Community.global.testUtil.TestData;
import com.baeker.Community.post.application.port.out.feign.StudyClientPort;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class ApiStudyClientMock extends TestData {

    @MockBean
    private StudyClientPort studyClientPort;

    public void memberCheckMocking() {
        when(studyClientPort.isMember(anyLong(), anyLong()))
                .thenAnswer(invocation -> {
                    Long studyId = (Long) invocation.getArgument(1);

                    if (studyId == 2L)
                        throw new FeignClientException("잘못된 요청입니다.", 400);

                    return ResponseEntity.noContent().build();
                });
    }
}
