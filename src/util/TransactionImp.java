package util;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionImp implements Transaction {
    @Override
    public void start() throws SQLException {
        Connection conn = null;
        conn = JDBCUtil.getConnection();
        //取消数据库的默认提交事件
        conn.setAutoCommit(false);
    }

    @Override
    public void rollback() throws SQLException {
        Connection conn = null;
        conn = JDBCUtil.getConnection();
        conn.rollback();
    }

    @Override
    public void commit() throws SQLException {
        Connection conn = null;
        conn = JDBCUtil.getConnection();
        conn.commit();
    }
}
