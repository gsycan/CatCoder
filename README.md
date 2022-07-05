# CatCoder
cat coder to be better for spring boot

## 初始化项目
2022.07.02
1. 增加热部署依赖，直接build即可生效 -> spring-boot-devtools 
   
2022.07.03
1. 增加mysql和mybatis依赖,使用Mybatis Generator根据mysql表反向映射生成dao、po和xml文件
2. 使用MyBatis plus的auto generator生成po、dao、mapper、controller和xml等
3. Spring Boot整合Swagger-UI实现在线API文档 。访问地址 http://localhost:8080/swagger-ui/
   
   3.1.1
   ● Swagger 是一种规范。
   ● springfox-swagger 是一个基于 Spring 生态系统的，Swagger 规范的实现。
   ● springfox-boot-starter 是 springfox 针对 Spring Boot 项目提供的一个 starter，简化 Swagger 依赖的导入，否则我们就需要在 pom.xml 文件中添加 springfox-swagger、springfox-swagger-ui 等多个依赖。
4. 解决Spring Boot 2.6.7 版本和 springfox 3.0.0 版本不兼容；解决方案地址：https://github.com/springfox/springfox/issues/3462

2022.07.04
1. 使用Knife4j美化swagger，在 pom.xml 文件中添加 Knife4j 的依赖（不需要再引入 springfox-boot-starter了，因为 Knife4j 的 starter 里面已经加入过了
   。访问地址为：http://localhost:8080/doc.html
2. 使用lombok快捷生产getter setter toString equals hashCode等等方法，lombok实在编译阶段运行的，所以代码中只通过注解实现就比较简洁，可以在
target目录下找到编译生成的完整字节码文件。
3. Hutool 的设计思想是尽量减少重复的定义，让项目中的 util 包尽量少。一个好的轮子可以在很大程度上避免“复制粘贴”，从而节省我们开发人员对项目中公用类库和公用工具方法的封装时间。 

2022.07.05
1. Spring Boot 整合 MySql和Druid。Druid 是阿里巴巴开源的一款数据库连接池，结合了C3P0、DBCP 等 DB 池的优点，同时还加入了日志监控。
2. 通过 http://localhost:9002/druid/ 地址就可以在浏览器访问 Druid 的监控页面了，用户名和密码是我们在配置文件里指定的 root 和 root
3. 配置druid数据源的时候之前的数据量连接信息url记得保留
4. IDEA2021与apache-maven-3.8.6不兼容，所以需要将maven调整为apache-maven-3.8.4就可以了。3.8.4版本maven对于仓库为repositoryv2
