package com.baeker.Community.global.testUtil;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.baeker.Community.global.testUtil.MockMvcRequest.post;

public class RequestCreateObject {

    public static Long createCodeReview(MockMvc mvc, String url, Long missionId, Long problemStatusId, int title, String jwt) throws Exception {
        CreateCodeReviewDto dto = new CreateCodeReviewDto(missionId, problemStatusId, "post" + title, "hello");
        ResultActions result = post(mvc, url + "/v1/code-review", jwt, dto);
        return MockMvcRequest.toResDto(result, CodeReviewDto.class).getId();
    }
}
