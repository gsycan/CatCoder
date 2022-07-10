package com.gsycan.catcoder.jpa.service;

import com.gsycan.catcoder.jpa.po.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 从日志当中可以看得出，Spring Data JPA 默认使用的是 Hibernate 框架
 */
public interface UserService {
    User findById(Integer id);

    List<User> findAll();

    User save(User user);

    void deleteById(Integer id);

    /**
     * 分页查询
     * ● Pageable 是 Spring 提供的一个分页查询接口，查询的时候只需要传入一个 Pageable 接口的实现类，指定第几页（pageNumber）和页面大小（pageSize）即可。
     * ● Page 是 Spring 提供的一个分页返回结果接口。
     */
    Page<User> findAllByPage(Pageable pageable);

    // 通过name模糊查询,@Query 注解会使用 JPQL 来进行查询
//    @Query("select u from User u where u.name like concat('%',?1,'%')")
//    @Query 注解中的 “User” 为实体类的类名，而非数据库的表名 user，这就是 JPQL 和原生 SQL 的区别。来看原生 SQL 的写法：
//    @Query 注解中的 “user” 为数据库表名，另外需要加上参数 nativeQuery，默认值为 false，设为 true 表明开启原生 SQL 查询。注意这次我们用“||”替换了“concat” 方法。
    @Query(value = "select * from user u where u.name like '%'|| ?1 || '%'", nativeQuery = true)
    List<User> findByNameLikeIgnoreCase(String name);
}
