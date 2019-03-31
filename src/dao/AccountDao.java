package dao;

import entity.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 根据查询帐号信息或全部信息
     * @param columnName 数据库的列名
     * @param flag 分页标志符
     * @param args 参数
     * @return List<Account>
     */
    List<Account> listAccountByConditionOrAll(String[] columnName, boolean flag, Object ... args);
}
