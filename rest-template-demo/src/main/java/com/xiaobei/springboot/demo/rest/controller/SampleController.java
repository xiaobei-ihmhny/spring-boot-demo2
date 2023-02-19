package com.xiaobei.springboot.demo.rest.controller;

import com.xiaobei.springboot.demo.common.CustomConfig;
import com.xiaobei.springboot.demo.rest.service.RestServiceSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("index")
@Controller
public class SampleController {

    @Autowired
    private RestServiceSample restServiceSample;

    @RequestMapping("demo")
    public String demo() {
        CustomConfig customConfig = new CustomConfig();
        customConfig.setName("xiaobei");
        customConfig.setEnv("dev");
        restServiceSample.postTest(customConfig);
        return "success";
    }
}
