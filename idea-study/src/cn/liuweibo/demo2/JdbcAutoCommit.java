package cn.liuweibo.demo2;

import cn.liuweibo.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 用事务模拟用户 SevenRyuu 给 DEMOSE 转账500
 */
public class JdbcAutoCommit {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm1 = null;
        PreparedStatement pstm2 = null;
        try {
            conn = JdbcUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            String sql1 = "update user set money = money - ? where id = ?";
            String sql2 = "update user set money = money + ? where id = ?";
            pstm1 = conn.prepareStatement(sql1);
            pstm2 = conn.prepareStatement(sql2);
            // 设置sql
            pstm1.setDouble(1, 500);
            pstm1.setInt(2, 46);
            pstm2.setDouble(1, 500);
            pstm2.setInt(2, 47);
            // 执行
            pstm1.executeUpdate();
            pstm2.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            JdbcUtils.close(pstm1, conn);
            JdbcUtils.close(pstm2, null);
        }

    }
}
