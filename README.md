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
   
2022.07.12
Spring Boot 整合 OSS 实现文件上传 --> 待服务器整合后配置redis和oos文件服务器

2022.07.14
1. 事务在逻辑上是一组操作，要么执行，要不都不执行。主要是针对数据库而言的，比如说 MySQL。同样的在spring框架中也整合了对事务的相关用法，原理基于数据库
2. 为了保证事务是正确可靠的，在数据库进行写入或者更新操作时，就必须得表现出 ACID 的 4 个重要特性： 
   - 原子性（Atomicity）：一个事务中的所有操作，要么全部完成，要么全部不完成，不会结束在中间某个环节。事务在执行过程中发生错误，会被回滚（Rollback）到事务开始前的状态，就像这个事务从来没有执行过一样。
   - 一致性（Consistency）：在事务开始之前和事务结束以后，数据库的完整性没有被破坏。
   - 事务隔离（Isolation）：数据库允许多个并发事务同时对其数据进行读写和修改，隔离性可以防止多个事务并发执行时由于交叉执行而导致数据的不一致。
   - 持久性（Durability）：事务处理结束后，对数据的修改就是永久的，即便系统故障也不会丢失。
其中，事务隔离又分为 4 种不同的级别，包括：
   - 未提交读（Read uncommitted），最低的隔离级别，允许“脏读”（dirty reads），事务可以看到其他事务“尚未提交”的修改。如果另一个事务回滚，那么当前事务读到的数据就是脏数据。
   - 提交读（read committed），一个事务可能会遇到不可重复读（Non Repeatable Read）的问题。不可重复读是指，在一个事务内，多次读同一数据，在这个事务还没有结束时，如果另一个事务恰好修改了这个数据，那么，在第一个事务中，两次读取的数据就可能不一致。
   - 可重复读（repeatable read），一个事务可能会遇到幻读（Phantom Read）的问题。幻读是指，在一个事务中，第一次查询某条记录，发现没有，但是，当试图更新这条不存在的记录时，竟然能成功，并且，再次读取同一条记录，它就神奇地出现了。
   - 串行化（Serializable），最严格的隔离级别，所有事务按照次序依次执行，因此，脏读、不可重复读、幻读都不会出现。虽然 Serializable 隔离级别下的事务具有最高的安全性，但是，由于事务是串行执行，所以效率会大大下降，应用程序的性能会急剧降低。如果没有特别重要的情景，一般都不会使用 Serializable 隔离级别。
需要格外注意的是：事务能否生效，取决于数据库引擎是否支持事务，MySQL 的 InnoDB 引擎是支持事务的，但 MyISAM 就不支持。
     
3. 关于 Spring 对事务的支持.Spring 支持两种事务方式，分别是编程式事务和声明式事务，后者最常见，通常情况下只需要一个 @Transactional 就搞定了（代码侵入性降到了最低）
4. 事务传播行为。当事务方法被另外一个事务方法调用时，必须指定事务应该如何传播，例如，方法可能继续在当前事务中执行，也可以开启一个新的事务，在自己的事务中执行。 
   声明式事务的传播行为可以通过 @Transactional  注解中的 propagation 属性来定义。
   TransactionDefinition 一共定义了 7 种事务传播行为：
   - PROPAGATION_REQUIRED：这也是 @Transactional  默认的事务传播行为，指的是如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。更确切地意思是： 
     a. 如果外部方法没有开启事务的话，Propagation.REQUIRED 修饰的内部方法会开启自己的事务，且开启的事务相互独立，互不干扰。
     b. 如果外部方法开启事务并且是 Propagation.REQUIRED 的话，所有 Propagation.REQUIRED 修饰的内部方法和外部方法均属于同一事务 ，只要一个方法回滚，整个事务都需要回滚。
      
   - PROPAGATION_REQUIRES_NEW:
     创建一个新的事务，如果当前存在事务，则把当前事务挂起。也就是说不管外部方法是否开启事务，Propagation.REQUIRES_NEW 修饰的内部方法都会开启自己的事务，且开启的事务与外部的事务相互独立，互不干扰。
     
   - PROPAGATION_NESTED
     如果当前存在事务，就在当前事务内执行；否则，就执行与 PROPAGATION_REQUIRED 类似的操作。
      
   - PROPAGATION_MANDATORY 
     如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。

   - PROPAGATION_SUPPORTS 
     如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。

   - PROPAGATION_NOT_SUPPORTED 
     以非事务方式运行，如果当前存在事务，则把当前事务挂起。

   - PROPAGATION_NEVER 
     以非事务方式运行，如果当前存在事务，则抛出异常。
     
5. 事务隔离级别

前面我们已经了解了数据库的事务隔离级别，再来理解 Spring 的事务隔离级别就容易多了。
TransactionDefinition 中一共定义了 5 种事务隔离级别：
● ISOLATION_DEFAULT，使用数据库默认的隔离级别，MySql 默认采用的是 REPEATABLE_READ，也就是可重复读。
● ISOLATION_READ_UNCOMMITTED，最低的隔离级别，可能会出现脏读、幻读或者不可重复读。
● ISOLATION_READ_COMMITTED，允许读取并发事务提交的数据，可以防止脏读，但幻读和不可重复读仍然有可能发生。
● ISOLATION_REPEATABLE_READ，对同一字段的多次读取结果都是一致的，除非数据是被自身事务所修改的，可以阻止脏读和不可重复读，但幻读仍有可能发生。
● ISOLATION_SERIALIZABLE，最高的隔离级别，虽然可以阻止脏读、幻读和不可重复读，但会严重影响程序性能。
通常情况下，我们采用默认的隔离级别 ISOLATION_DEFAULT 就可以了，也就是交给数据库来决定，

6. 事务的超时时间
事务超时，也就是指一个事务所允许执行的最长时间，如果在超时时间内还没有完成的话，就自动回滚。
假如事务的执行时间格外的长，由于事务涉及到对数据库的锁定，就会导致长时间运行的事务占用数据库资源。

7. 事务的只读属性
如果一个事务只是对数据库执行读操作，那么该数据库就可以利用事务的只读属性，采取优化措施，适用于多条数据库查询操作中。
为什么一个查询操作还要启用事务支持呢？
这是因为 MySql（innodb）默认对每一个连接都启用了 autocommit 模式，在该模式下，每一个发送到 MySql 服务器的 SQL 语句都会在一个单独的事务中进行处理，执行结束后会自动提交事务。
那如果我们给方法加上了 @Transactional  注解，那这个方法中所有的 SQL 都会放在一个事务里。否则，每条 SQL 都会单独开启一个事务，中间被其他事务修改了数据，都会实时读取到。
有些情况下，当一次执行多条查询语句时，需要保证数据一致性时，就需要启用事务支持。否则上一条 SQL 查询后，被其他用户改变了数据，那么下一个 SQL 查询可能就会出现不一致的状态。

8. 事务的回滚策略
默认情况下，事务只在出现运行时异常（Runtime Exception）时回滚，以及 Error，出现检查异常（checked exception，需要主动捕获处理或者向上抛出）时不回滚。
   
9. 关于 Spring Boot 对事务的支持

以前，我们需要通过 XML 配置 Spring 来托管事务，有了 Spring Boot 之后，一切就变得更加简单了，只需要在业务层添加事务注解（@Transactional）就可以快速开启事务。
也就是说，我们只需要把焦点放在 @Transactional 注解上就可以了。

@Transactional  的作用范围
● 类上，表明类中所有 public 方法都启用事务
● 方法上，最常用的一种
● 接口上，不推荐使用

@Transactional  的常用配置参数
虽然 @Transactional  注解源码中定义了很多属性，但大多数时候，我都是采用默认配置，当然了，如果需要自定义的话，前面也都说明过了。

@Transactional  的使用注意事项总结
1）要在 public 方法上使用，在AbstractFallbackTransactionAttributeSource类的computeTransactionAttribute方法中有个判断，如果目标方法不是public，则TransactionAttribute返回null，即不支持事务。
2）避免同一个类中调用 @Transactional  注解的方法，这样会导致事务失效。 