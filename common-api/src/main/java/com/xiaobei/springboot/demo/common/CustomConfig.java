package com.xiaobei.springboot.demo.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Getter
@Setter
@ToString
public class CustomConfig {

    private String name;

    private String env;

    private RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
}
