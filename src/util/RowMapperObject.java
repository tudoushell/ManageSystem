package util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 行映射对象
 */
public interface RowMapperObject {
    /**
     * 将结果集所指行转为对象，需要将结果集转为对象的位置必须重写该方法
     * @param rs
     * @return
     * @throws SQLException
     */
    Object rowMapperObject(ResultSet rs) throws SQLException;
}
