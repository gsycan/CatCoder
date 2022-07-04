package com.gsycan.catcoder.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基于 knife4j美化swagger，用法和swagger一致 参考SwaggerController和SwaggerConfig
 *
 * 访问地址为：http://localhost:8080/doc.html
 */
@Api(tags = "Knife4j 测试")
@RestController
@RequestMapping("/v3/knife4j")
public class Knife4jController {

    @ApiOperation("knife4j demo 1")
    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public String hello() {
        return "肉肉又萌又傻~";
    }
}
