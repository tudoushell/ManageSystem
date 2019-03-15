package entity.RowMapping;

import entity.UserPrivileges;
import util.RowMapperObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPrivilegesRowMapping implements RowMapperObject {
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        UserPrivileges userPrivileges = new UserPrivileges();
        userPrivileges.setId(rs.getInt("id"));
        userPrivileges.setRoleId(rs.getInt("role_id"));
        userPrivileges.setRoleName(rs.getString("role_name"));
        userPrivileges.setMenuId(rs.getString("menu_id"));
        userPrivileges.setMenuName(rs.getString("menu_name"));
        return userPrivileges;
    }
}
