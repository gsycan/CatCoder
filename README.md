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

2022.07.10
1. Spring Boot 整合 JPA 。Spring Data 是 Spring 提供的一个操作数据的框架，Spring Data JPA是 Spring Data 下的一个基于 JPA 标准的操作数据的模块。
。JPA（Java Persistence API）是 Java 亲妈 Sun 公司提出的一套 Java 持久化规范。所谓规范，就是只定义标准，不提供实现。
2. 需要添加相关pom依赖  spring-boot-starter-data-jpa
3. Mybatis和SPring Data JPA 对比： 
   1）MyBatis 是针对SQL 的，上手难度比 Spring Data JPA 面向 JPQL 要稍微容易一些。但在 Intellij IDEA 这种集成开发环境的代码提示下，优势并不大。 
   2）Spring Data JPA 的资料相对少一些，而 MyBatis 的资料可以说非常全面了，遇到问题基本上都能找到解决方案，另外像 MyBatis-Plus 的出现，在一定程度上增强了 MyBatis 的能力。 
   3）Spring Data JPA 一开始在动态 SQL 能力上不如 MyBatis，但随着 Spring Boot 和 Spring Data JPA 的无缝衔接，Spring Data JPA 的应用会越来越广泛，事实上，国外用 Spring Data JPA 的就比 MyBatis 的多一些。

4. Spring Data JPA，优点： 
   1）新项目不用事先设计数据库和表结构，开发过程中可以自动根据实体类生成数据库和表结构，更容易快速迭代。 
   2）能减少切换数据库带来的改造成本，因为 Spring Data JPA 底层屏蔽了 ORM 框架的差异性；再者不用写原生 SQL 的话，也屏蔽了数据库之间的 SQL 差异性。 
   3）持久层的代码量更少，维护起来更加简单和方便，更多的时候，只需要维护 entity 和 Respository 接口之间的映射关系就可以了

2022.07.11
1. Redis 是使用 C 语言开发的一个高性能键值对数据库，是互联网技术领域使用最为广泛的存储中间件，它是「Remote Dictionary Service」的首字母缩写，也就是「远程字典服务」。 
   安装redis：https://blog.csdn.net/yangwenxue1989/article/details/88884668?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-88884668-blog-123835625.pc_relevant_aa&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-88884668-blog-123835625.pc_relevant_aa&utm_relevant_index=2；
   安装redis客户端:Another Redis Desktop Manager
   
2. 此项目是Spring Boot + Vue 的前后端分离项目，要整合 Redis 的话，最好的方式是使用 Spring Cache，仅仅通过 @Cacheable、@CachePut、@CacheEvict、@EnableCaching 等注解就可以轻松使用 Redis 做缓存了。 
   1）@EnableCaching  ，开启缓存功能。 
   2）@Cacheable  ，调用方法前，去缓存中找，找到就返回，找不到就执行方法，并将返回值放到缓存中。 
   3）@CachePut  ，方法调用前不会去缓存中找，无论如何都会执行方法，执行完将返回值放到缓存中。 
   4）@CacheEvict  ，清理缓存中的一个或多个记录。 
   Spring Cache 是 Spring 提供的一套完整的缓存解决方案，虽然它本身没有提供缓存的实现，但它提供的一整套接口、规范、配置、注解等，可以让我们无缝衔接 Redis、Ehcache 等缓存实现。
   
3. redis连接池
   Redis 是基于内存的数据库，本来是为了提高程序性能的，但如果不使用 Redis 连接池的话，建立连接、断开连接就需要消耗大量的时间。 
   用了连接池，就可以实现在客户端建立多个连接，需要的时候从连接池拿，用完了再放回去，这样就节省了连接建立、断开的时间。 
   要使用连接池，我们得先了解 Redis 的客户端，常用的有两种：Jedis 和 Lettuce。 
   - Jedis：Spring Boot 1.5.x 版本时默认的 Redis 客户端，实现上是直接连接 Redis Server，如果在多线程环境下是非线程安全的，这时候要使用连接池为每个 jedis 实例增加物理连接； 
   - Lettuce：Spring Boot 2.x 版本后默认的 Redis 客户端，基于 Netty 实现，连接实例可以在多个线程间并发访问，一个连接实例不够的情况下也可以按需要增加连接实例。