package com.xiaobei.springboot.demo.servlet;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class ServletDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletDemoApplication.class, args);
    }

}
