package com.gsycan.catcoder.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基于Swagger实现的在线API文档
 * 启动服务，在浏览器中输入 http://localhost:8080/swagger-ui/ 就可以访问 Swagger 生成的 API 文档了。
 *
 * 1）@Api注解，用在类上，该注解将控制器标注为一个 Swagger 资源。该注解有 3 个属性：
 * ● tags，具有相同标签的 API 会被归在一组内展示
 * ● value，如果 tags 没有定义，value 将作为 API 的 tags 使用。
 * ● description，已废弃
 *
 * 2）@ApiOperation  注解，用在方法上，描述这个方法是做什么用的。该注解有 4 个属性：
 * ● value 操作的简单说明，长度为120个字母，60个汉字。
 * ● notes 对操作的详细说明。
 * ● httpMethod HTTP请求的动作名，可选值有："GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS" and "PATCH"。
 * ● code 默认为200，有效值必须符合标准的HTTP Status Code Definitions。
 *
 * 3）@RestController  注解，用在类上，是@ResponseBody和@Controller的组合注解，如果方法要返回 JSON 的话，可省去 @ResponseBody  注解。
 *
 * 4）@RequestMapping  注解，可用在类（父路径）和方法（子路径）上，主要用来定义 API 的请求路径和请求类型。该注解有 6 个属性：
 * ● value，指定请求的实际地址
 * ● method，指定请求的method类型， GET、POST、PUT、DELETE等
 * ● consumes，指定处理请求的提交内容类型（Content-Type），例如 application/json, text/html
 * ● produces，指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回
 * ● params，指定request中必须包含某些参数值
 * ● headers，指定request中必须包含某些指定的header值
 */

@Api(tags = "Swagger Demo~")
@RestController
@RequestMapping("/v3/swagger")
public class SwaggerController {

    @ApiOperation("demo hello")
    @RequestMapping("/demo")
    public String swaggerDemo() {
        return "hello, 使用swagger实现的在线API文档！";
    }
}
