package com.baeker.Community.global.testUtil;

import com.baeker.Community.global.dto.reqDto.CreateCodeReviewDto;
import com.baeker.Community.global.dto.reqDto.CreateCommentDto;
import com.baeker.Community.global.dto.resDto.CodeReviewDto;
import com.baeker.Community.global.dto.resDto.CommentDto;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.baeker.Community.global.testUtil.MockMvcRequest.patch;
import static com.baeker.Community.global.testUtil.MockMvcRequest.post;

public class TestApiUtil {

    public static Long createCodeReview(MockMvc mvc, String url, Long missionId, Long problemStatusId, int title, String jwt) throws Exception {
        CreateCodeReviewDto dto = new CreateCodeReviewDto(missionId, problemStatusId, "post" + title, "hello");
        ResultActions result = post(mvc, url + "/v1/code-review", jwt, dto);
        return MockMvcRequest.toResDto(result, CodeReviewDto.class).getId();
    }

    public static Long createCodeReview(MockMvc mvc, String url, int title, String jwt) throws Exception {
        CreateCodeReviewDto dto = new CreateCodeReviewDto(1L, 1L, "post" + title, "hello");
        ResultActions result = post(mvc, url + "/v1/code-review", jwt, dto);
        return MockMvcRequest.toResDto(result, CodeReviewDto.class).getId();
    }

    public static Long createComment(MockMvc mvc, String url, Long postId, String jwt) throws Exception {
        CreateCommentDto dto = new CreateCommentDto(postId, "comment");
        ResultActions result = post(mvc, url + "/v1", jwt, dto);
        return MockMvcRequest.toResDto(result, CommentDto.class).getCommentId();
    }

    public static void follow(MockMvc mvc, String url, Long postId, String jwt) throws Exception {
        patch(mvc, url + "/v1/follow/{postId}", jwt, postId);
    }
}
