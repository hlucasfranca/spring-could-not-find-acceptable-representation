package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @PostMapping(value = "/test",
            consumes = {MediaType.ALL_VALUE},
            produces = {MediaType.ALL_VALUE})
    public Parent test() {
        return new Parent("parent", new Child("child"));
    }
}
