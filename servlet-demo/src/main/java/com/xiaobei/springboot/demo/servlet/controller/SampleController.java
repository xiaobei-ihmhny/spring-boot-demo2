package com.xiaobei.springboot.demo.servlet.controller;

import com.xiaobei.springboot.demo.common.CustomConfig;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sample")
@RestController
public class SampleController {

    @PostMapping("someString")
    public String someString(@RequestBody CustomConfig customConfig) {
        return "Hello World";
    }
}
