package com.gsycan.catcoder.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Swagger配置类
 * Swagger 提供了调用端代码、服务端代码以及接口文档的不一致的问题
 * NOTE:
 * 1）@Configuration  注解通常用来声明一个 Java 配置类，取代了以往的 xml 配置文件，让配置变得更加的简单和直接。
 * 2）@EnableOpenApi  注解表明开启 Swagger。
 * 3）SwaggerConfig 类中包含了一个 @Bean  注解声明的方法 docket()，该方法会被 Spring 的 AnnotationConfigApplicationContext 或
 *    AnnotationConfigWebApplicationContext 类进行扫描，然后添加到 Spring 容器当中。
 */

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.OAS_30) //使用 3.0 版本的 Swagger API。OAS 是 OpenAPI Specification 的简称，翻译成中文就是 OpenAPI 说明书，Swagger 遵循的就是这套规范。
                .apiInfo(apiInfo()).enable(true)
                .select()
                // apis 添加swagger接口提取的范围  即指定 API 的接口范围为 controller 控制器
                .apis(RequestHandlerSelectors.basePackage("com.gsycan.catcoder.controller")) //指定URL地址
                .paths(PathSelectors.any()) // 指定匹配所有的 URL
                .build();
        return docket;
    }

    /**
     * 配置 API 文档基本信息，标题、描述、作者、版本等
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("编程猫肉肉的实战项目笔记 冲鸭！")
                .description("catcoder是一个Spring Boot + vue 实现的前后端分离项目")
                .contact(new Contact("gsycan", "https://github.com/gsycan/CatCoder", "gsycan@163.com"))
                .version("v1.0")
                .build();
    }

    /**
     * 解决Spring Boot 2.6.7 版本和 springfox 3.0.0 版本不兼容
     * 解决方案地址：https://github.com/springfox/springfox/issues/3462
     */
    @Bean
    public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return new BeanPostProcessor() {

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof WebMvcRequestHandlerProvider || bean instanceof WebFluxRequestHandlerProvider) {
                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
                }
                return bean;
            }

            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
                List<T> copy = mappings.stream()
                        .filter(mapping -> mapping.getPatternParser() == null)
                        .collect(Collectors.toList());
                mappings.clear();
                mappings.addAll(copy);
            }

            @SuppressWarnings("unchecked")
            private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
                try {
                    Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
                    field.setAccessible(true);
                    return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
    }

}
