package com.gsycan.catcoder.controller;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * HuTool 一种开源的工具包
 */
public class HuToolController {
    private static final Log logger = LogFactory.get(); // 默认 Slf4j

    public static void main(String[] args) {
        logger.info("使用hutool的日志工具，userId:{}", "rourou");

        // 加密解密
        MD5 md5 = SecureUtil.md5();
        String data = "haha";
        String encry = md5.digestHex16(data);
        logger.info("{}加密后:{}", data, encry);
        String res = md5.digestHex16(encry);
        logger.info("{}jie密后:{}", data, res);
    }
}
