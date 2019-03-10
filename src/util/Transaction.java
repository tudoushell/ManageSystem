package util;

import java.sql.SQLException;

/**
 *  数据库的事务
 */
public interface Transaction {
    void start() throws SQLException;
    void rollback() throws  SQLException;
    void commit() throws  SQLException;
}
