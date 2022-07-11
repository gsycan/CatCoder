package com.gsycan.catcoder.controller;

import com.gsycan.catcoder.service.RedisCacheService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * redis + spring cache 实现注解缓存管理
 *
 *    1）@EnableCaching  ，开启缓存功能。
 *    2）@Cacheable  ，调用方法前，去缓存中找，找到就返回，找不到就执行方法，并将返回值放到缓存中。
 *    3）@CachePut  ，方法调用前不会去缓存中找，无论如何都会执行方法，执行完将返回值放到缓存中。
 *    4）@CacheEvict  ，清理缓存中的一个或多个记录。
 *    Spring Cache 是 Spring 提供的一套完整的缓存解决方案，虽然它本身没有提供缓存的实现，但它提供的一整套接口、规范、配置、注解等，可以让我们无缝衔接 Redis、Ehcache 等缓存实现。
 *
 *
 *  @CachePut(value = "codingmore", key = "'codingmore:postags:'+#param")
 *  ● value：缓存名称，也就是缓存的命名空间，value 这里应该换成 namespace 更好一点；
 *  ● key：用于在命名空间中缓存的 key 值，可以使用 SpEL 表达式，比如说 'codingmore:postags:'+#param； key:value
 *  ● 还有两个属性 unless 和 condition 暂时没用到，分别表示条件符合则不缓存，条件符合则缓存。
 */
@RestController
@Api(tags = "redis-缓存测试")
@RequestMapping("/redis/test")
@Slf4j
public class RedisCacheController {

    @Autowired
    private RedisCacheService redisCacheService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("修改缓存")
    @Cacheable(value = "catCoderNameSpace", key = "'catCoder:id:'+#id")
    public HashMap<String, Object> update(@RequestParam Integer id, @RequestParam String param) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (param == null) {
            log.info("更新参数不能为空！");
            hashMap.put("msg", "更新失败");
            return hashMap;
        }
        log.info("使用新参数param:{} 进行service业务更新操作.....", param);
        hashMap.put("msg", "更新成功");
        hashMap.put("id", id);
        hashMap.put("param", param);
        return hashMap;
    }

    @RequestMapping(value = "/update2", method = RequestMethod.POST)
    @ApiOperation("修改缓存-service存储缓存")
    public HashMap<String, Object> update2(@RequestParam Integer id, @RequestParam String param) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (param == null) {
            log.info("更新参数不能为空！");
            hashMap.put("msg", "更新失败");
            return hashMap;
        }
        log.info("api调用redisCacheService操作.....param：{}", param);
        String res = redisCacheService.say(id, param);
        hashMap.put("msg", "更新成功");
        hashMap.put("res", res);
        return hashMap;
    }
}
