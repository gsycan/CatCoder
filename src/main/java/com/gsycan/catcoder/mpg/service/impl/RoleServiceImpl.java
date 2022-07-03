package com.gsycan.catcoder.mpg.service.impl;

import com.gsycan.catcoder.mpg.entity.Role;
import com.gsycan.catcoder.mpg.mapper.RoleMapper;
import com.gsycan.catcoder.mpg.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author gsycan
 * @since 2022-07-03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
