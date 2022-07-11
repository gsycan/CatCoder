package com.gsycan.catcoder;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * redis客户端测试
 *
 * RedisTemplate 和 StringRedisTemplate 都是 Spring Data Redis 提供的模板类，可以对 Redis 进行操作，后者针对键值对都是 String 类型的数据，前者可以是任何类型的对象。
 * RedisTemplate 和 StringRedisTemplate 除了提供 opsForValue 方法来操作字符串之外，还提供了以下方法：
 *
 * ● opsForList：操作 list
 * ● opsForSet：操作 set
 * ● opsForZSet：操作有序 set
 * ● opsForHash：操作 hash
 */
@SpringBootTest
@Slf4j
public class CatcoderRedisApplicationTests {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis() {
        redisTemplate.opsForValue().set("nameGsy", "gsy1");
        log.info("redisTemplate 添加查询name:{}", redisTemplate.opsForValue().get("nameGsy"));

//        redisTemplate.delete("nameGsy"); // 删除

        redisTemplate.opsForValue().set("nameGsy", "gsy111", 10, TimeUnit.SECONDS);
        log.info("redisTemplate 添加查询更新name:{}", redisTemplate.opsForValue().get("nameGsy"));

        stringRedisTemplate.opsForValue().set("nameGsyStr", "gsy22", 20, TimeUnit.SECONDS);
        log.info("stringRedisTemplate 添加查询name:{}", stringRedisTemplate.opsForValue().get("nameGsyStr"));


    }
}
