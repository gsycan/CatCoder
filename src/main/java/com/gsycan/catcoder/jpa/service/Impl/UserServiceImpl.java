package com.gsycan.catcoder.jpa.service.Impl;

import com.gsycan.catcoder.jpa.dao.UserRepository;
import com.gsycan.catcoder.jpa.po.User;
import com.gsycan.catcoder.jpa.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ● @Service 注解用在服务层，和 @Component 注解作用类似（通用注解），Spring Boot 会自动扫描该类注解注解的类，并把它们假如到 Spring 容器中。
 * ● @Resource 和 @Autowired 注解都是用来自动装配对象的，可以用在字段上，也可以用在 setter 方法上。@Autowired  是 Spring 提供的注解，@Resource  是 Java 提供的注解，也就是说，如果项目没有使用 Spring 框架而是 JFinal 框架，@Resource  注解也是支持的。另外，@Resource  是 byName 自动装配，@Autowired  是 byType 自动装配，当有两个类型完全一样的对象时，@Autowired  就会出错了。
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> findAllByPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> findByNameLikeIgnoreCase(String name) {
        return userRepository.findByNameLikeIgnoreCase(name); // 在dao通过JPA自定义生成接口
    }
}
