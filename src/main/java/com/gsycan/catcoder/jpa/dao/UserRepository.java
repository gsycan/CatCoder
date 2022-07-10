package com.gsycan.catcoder.jpa.dao;

import com.gsycan.catcoder.jpa.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 在目录右键-> new -> JPA -> Repository 选择实体生产的接口类
 * 如果只是简单的对表进行增删改查操作，那么只需要继承 JpaRepository 接口，并传递两个参数（第一个为实体类，第二个为主键类型）即可。
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    // 在JPA Palette面板双击 Find Collection 填写属性和查询方式自动生成接口
    List<User> findByNameLikeIgnoreCase(String name);
}