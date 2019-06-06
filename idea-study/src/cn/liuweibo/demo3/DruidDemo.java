package cn.liuweibo.demo3;

import cn.liuweibo.util.JdbcDruidUtils;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JdbcDruidUtils.getConnection();
            String sql = "update user set money = money + ? where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1,500);
            stmt.setInt(2,46);
            int count = stmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcDruidUtils.close(stmt,conn);
        }

    }
}
