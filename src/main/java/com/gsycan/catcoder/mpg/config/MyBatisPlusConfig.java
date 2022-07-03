package com.gsycan.catcoder.mpg.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 使用MyBatis Plus的auto generator生成的mapper接口中缺少@Mapper,使用@Configuration注解用来声明一个 Java 配置类
 * 或者每个mapper的接口添加@Mapper也可以，只是比较繁琐
 */

@Configuration
@MapperScan("com.gsycan.catcoder.mpg.mapper")
public class MyBatisPlusConfig {
}
