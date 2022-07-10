package com.gsycan.catcoder;

import com.gsycan.catcoder.jpa.po.User;
import com.gsycan.catcoder.jpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

/**
 * JPA测试类
 */
@SpringBootTest
@Slf4j
public class CodingmoreJpaApplicationTests {

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
        // 查询所有
        // JPA默认使用Hibernate框架 Hibernate: select user0_.id as id1_0_, user0_.age as age2_0_, user0_.name as name3_0_, user0_.password as password4_0_ from user_test user0_
        userService.findAll().stream().forEach(user -> log.info("查询所有{}", user));

        // 新增数据
        userService.save(new User(2,12,"小肉肉", "123321"));
        userService.save(new User(3,22,"锅包肉", "4444"));
        userService.save(new User(4,52,"猫猫", "2222"));

        // 分页查询
        userService.findAllByPage(PageRequest.of(1,2)).stream()
                .forEach(user -> log.info("分页查询 user:{}", user));

        // 模糊查询
        log.info("模糊查询:{}", userService.findByNameLikeIgnoreCase("猫猫"));

        // 删除
        userService.deleteById(1);
    }
}
