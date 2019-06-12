package cn.liuweibo.service.impl;

import cn.liuweibo.dao.UserDao;
import cn.liuweibo.dao.impl.UserDaoImpl;
import cn.liuweibo.domain.User;
import cn.liuweibo.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    public List<User> findAll(){
        // 调用 Dao 完成查询
        return dao.findAll();
    }
}
