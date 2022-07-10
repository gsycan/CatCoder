package com.gsycan.catcoder;

import com.gsycan.catcoder.jpa.po.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @SpringBootTest 注解能够测试我们的项目主类
 * @Test 注解是 junit 单元测试的注解，表示该方法为测试方法。
 * JdbcTemplate 一个通过 JDBC 连接数据库的工具类，spring-boot-starter-jdbc 依赖中包含了该类。
 * @Resource 注解会帮我们在 Spring Boot 启动的时候注入一个 JdbcTemplate 的对象。
 */
@SpringBootTest
@Slf4j
class CatcoderApplicationTests {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
		String sql = "select * from user_test";
		List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
			//RowMapper 就是查询到的每一行数据对象，我们可以通过重写 mapRow 方法将数据结果集封装到 User 对象上。
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setAge(rs.getInt("age"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
		log.info("用户:{}", users);
	}

}
