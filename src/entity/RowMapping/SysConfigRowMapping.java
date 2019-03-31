package entity.RowMapping;

import entity.SysConfig;
import util.RowMapperObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SysConfigRowMapping implements RowMapperObject {
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        SysConfig sysConfig = new SysConfig();
        sysConfig.setId(rs.getInt("id"));
        sysConfig.setConfigType(rs.getString("config_type"));
        sysConfig.setConfigKey(rs.getString("config_key"));
        sysConfig.setConfigPageValue(rs.getString("config_page_value"));
        sysConfig.setCreateTime(rs.getString("create_time"));
        return sysConfig;
    }
}
