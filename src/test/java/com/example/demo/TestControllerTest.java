package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSuccessResponse() throws Exception {
        mockMvc.perform(post("/test").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"name\" : \"parent\",\n" +
                        "  \"child\" : {\n" +
                        "    \"name\" : \"child\"\n" +
                        "  }\n" +
                        "}"));
    }

    @Test
    public void testErrorResponse() throws Exception {

        /**
         *
         * Uncomment
         *
         * supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
         * supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
         *
         * in Config class to make the controller works
         *
         * or else 500 status code is returned
         *
         */
        mockMvc.perform(post("/test")
                        .accept(MediaType.APPLICATION_FORM_URLENCODED))
                        .andExpect(status().is5xxServerError());
    }
}
