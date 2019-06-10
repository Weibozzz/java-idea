package cn.liuweibo.test;


import cn.liuweibo.dao.UserDao;
import cn.liuweibo.demain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void TestLogin(){
        User loginuser = new User();
        loginuser.setUsername("DEMOSE");
        loginuser.setPassword("123456");
        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);

    }
}
