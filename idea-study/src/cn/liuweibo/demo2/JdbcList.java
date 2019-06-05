package cn.liuweibo.demo2;

import cn.liuweibo.domain.User;

import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcList {
    public static void main(String[] args) {
        List<User> list = new JdbcList().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }
    public List<User> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<User> list = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///blog", "root", "");
            String sql = "select * from user";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            list = new ArrayList<User>();
            while (rs.next()){
                int id = rs.getInt(1);
                String username = rs.getString("username");
                User user = new User();
                user.setId(id);
                user.setUsername(username);
                list.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

}
