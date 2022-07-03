# CatCoder
cat coder to be better for spring boot

## 初始化项目
2022.07.02
1. 增加热部署依赖，直接build即可生效 -> spring-boot-devtools 
   
2022.07.03
1. 增加mysql和mybatis依赖,使用Mybatis Generator根据mysql表反向映射生成dao、po和xml文件
2. 使用MyBatis plus的auto generator生成po、dao、mapper、controller和xml等
3. Spring Boot整合Swagger-UI实现在线API文档
    3.1.1
   ● Swagger 是一种规范。
   ● springfox-swagger 是一个基于 Spring 生态系统的，Swagger 规范的实现。
   ● springfox-boot-starter 是 springfox 针对 Spring Boot 项目提供的一个 starter，简化 Swagger 依赖的导入，否则我们就需要在 pom.xml 文件中添加 springfox-swagger、springfox-swagger-ui 等多个依赖。
4. 解决Spring Boot 2.6.7 版本和 springfox 3.0.0 版本不兼容；解决方案地址：https://github.com/springfox/springfox/issues/3462