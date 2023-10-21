package com.baeker.Community.global.testUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class MockMvcRequest<T> {

    private T data;

    public static ResultActions post(MockMvc mvc, String url, String jwt, Object reqDto) throws Exception {
        String dto = toJasonString(reqDto);
        return mvc.perform(MockMvcRequestBuilders
                .post(url)
                .contentType(APPLICATION_JSON)
                .header("Authorization", jwt)
                .content(dto)
        ).andDo(print());
    }

    private static String toJasonString(Object reqDto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(reqDto);
    }

    public static <T> T toResDto(ResultActions result, Class<T> data) throws UnsupportedEncodingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = result.andReturn();
        return mapper
                .registerModule(new JavaTimeModule())
                .readValue(mvcResult.getResponse().getContentAsString(), data);
    }
}
