package com.gsycan.catcoder.mpg.service.impl;

import com.gsycan.catcoder.mpg.entity.Posts;
import com.gsycan.catcoder.mpg.mapper.PostsMapper;
import com.gsycan.catcoder.mpg.service.IPostsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author gsycan
 * @since 2022-07-03
 */
@Service
public class PostsServiceImpl extends ServiceImpl<PostsMapper, Posts> implements IPostsService {

}
