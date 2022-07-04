package com.gsycan.catcoder.controller;

import com.gsycan.catcoder.vo.HelloLombokVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/demo")
public class HelloController {

    @RequestMapping("/hello")
    public String hello () {
        return "hello world! 使用spring-boot-devtools热部署生效~~~";
    }

    @RequestMapping(value = "/lombok", method = RequestMethod.POST)
    public HelloLombokVo lombok () {
        HelloLombokVo vo = new HelloLombokVo();
        vo.setId(1);
        vo.setName("rourou");
        vo.setDesc("帅气");
        return vo;
    }
}
