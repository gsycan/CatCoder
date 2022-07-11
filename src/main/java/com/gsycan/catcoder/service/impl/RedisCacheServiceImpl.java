package com.gsycan.catcoder.service.impl;

import com.gsycan.catcoder.service.RedisCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisCacheServiceImpl implements RedisCacheService {

    @Cacheable(value = "catCoderNameSpace2", key = "'catCoder:id:'+#id")
    @Override
    public String say(Integer id, String message) {
        log.info("id:{} --service进行处理，获取参数message:{}", id, message);
        return String.format("when u wait, i say %s", message);
    }
}
