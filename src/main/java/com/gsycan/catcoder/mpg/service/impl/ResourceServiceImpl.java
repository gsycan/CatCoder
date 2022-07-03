package com.gsycan.catcoder.mpg.service.impl;

import com.gsycan.catcoder.mpg.entity.Resource;
import com.gsycan.catcoder.mpg.mapper.ResourceMapper;
import com.gsycan.catcoder.mpg.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台资源表 服务实现类
 * </p>
 *
 * @author gsycan
 * @since 2022-07-03
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {

}
