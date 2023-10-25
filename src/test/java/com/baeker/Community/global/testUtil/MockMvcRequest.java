package com.baeker.Community.global.testUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class MockMvcRequest {

    public static ResultActions post(MockMvc mvc, String url, String jwt, Object reqDto) throws Exception {
        String dto = toJasonString(reqDto);
        return mvc.perform(MockMvcRequestBuilders
                .post(url)
                .contentType(APPLICATION_JSON)
                .header("Authorization", jwt)
                .content(dto)
        ).andDo(print());
    }

    public static ResultActions patch(MockMvc mvc, String url, String jwt, Long pathVariable) throws Exception {
        return mvc.perform(MockMvcRequestBuilders
                .patch(url, pathVariable)
                .contentType(APPLICATION_JSON)
                .header("Authorization", jwt)
        ).andDo(print());
    }

    public static ResultActions get(MockMvc mvc, String url, Long pathVariable1) throws Exception {
        return mvc.perform(MockMvcRequestBuilders
                .get(url, pathVariable1)
                .contentType(APPLICATION_JSON)
        ).andDo(print());
    }

    public static ResultActions get(MockMvc mvc, String url, Long pathVariable1, Long pathVariable2) throws Exception {
        return mvc.perform(MockMvcRequestBuilders
                .get(url, pathVariable1, pathVariable2)
                .contentType(APPLICATION_JSON)
        ).andDo(print());
    }



    private static String toJasonString(Object reqDto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(reqDto);
    }

    public static <T> T toResDto(ResultActions result, Class<T> data) throws UnsupportedEncodingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = result.andReturn();
        String content = mvcResult.getResponse().getContentAsString();

        return mapper
                .registerModule(new JavaTimeModule())
                .readValue(content, data);
    }

    public static  <T> List<T> toList(ResultActions result, Class<T> data) throws UnsupportedEncodingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = result.andReturn();
        String content = mvcResult.getResponse().getContentAsString();

        CollectionType dataType = mapper
                .getTypeFactory()
                .constructCollectionType(List.class, data);

        return mapper
                .registerModule(new JavaTimeModule())
                .readValue(content, dataType);
    }
}
