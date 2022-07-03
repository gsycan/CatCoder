package com.gsycan.catcoder.mpg.service.impl;

import com.gsycan.catcoder.mpg.entity.Menu;
import com.gsycan.catcoder.mpg.mapper.MenuMapper;
import com.gsycan.catcoder.mpg.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台菜单表 服务实现类
 * </p>
 *
 * @author gsycan
 * @since 2022-07-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
