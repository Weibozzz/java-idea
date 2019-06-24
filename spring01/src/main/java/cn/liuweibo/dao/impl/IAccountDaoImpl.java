package cn.liuweibo.dao.impl;

import cn.liuweibo.dao.IAccountDao;
import cn.liuweibo.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层实现
 */
@Component("accountDao")
public class IAccountDaoImpl implements IAccountDao {
    @Autowired
    private QueryRunner runner;

    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from user", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("select * from user where id = ?", new BeanHandler<Account>(Account.class), accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update("insert into user(username,money)values(?,?)", account.getUsername(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("update user set username = ?,money=? where id = ?", account.getUsername(), account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            runner.update("delete from user where id = ?", accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
