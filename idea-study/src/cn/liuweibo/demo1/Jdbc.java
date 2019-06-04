package cn.liuweibo.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc {
    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///blog","root","");
        String sql = "update user set nickName = 'test1' where id = 46";
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        System.out.println(count);
        stmt.close();
        conn.close();
    }
}
