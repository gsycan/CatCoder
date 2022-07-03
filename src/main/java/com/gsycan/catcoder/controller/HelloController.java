package com.gsycan.catcoder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/demo")
public class HelloController {

    @RequestMapping("/hello")
    public String hello () {
        return "hello world! 使用spring-boot-devtools热部署生效~~~";
    }
}
