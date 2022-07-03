package com.gsycan.catcoder.mpg.service.impl;

import com.gsycan.catcoder.mpg.entity.Users;
import com.gsycan.catcoder.mpg.mapper.UsersMapper;
import com.gsycan.catcoder.mpg.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author gsycan
 * @since 2022-07-03
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
