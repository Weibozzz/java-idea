package cn.liuweibo.dao.impl;

import cn.liuweibo.dao.UserDao;
import cn.liuweibo.domain.User;
import cn.liuweibo.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
    public List<User> findAll(){
        // 使用JDBC操作数据库
        String sql = "select * from user";
        List<User> users = template.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
}
