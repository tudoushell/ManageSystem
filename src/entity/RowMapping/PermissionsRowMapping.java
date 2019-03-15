package entity.RowMapping;

import entity.Permissions;
import util.RowMapperObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PermissionsRowMapping implements RowMapperObject {
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        Permissions p = new Permissions();
        p.setId(rs.getInt("id"));
        p.setRoleId(rs.getString("role_id"));
        p.setMenuId(rs.getString("menu_id"));
        p.setCreateTime(rs.getString("create_time"));
        return p;
    }
}
