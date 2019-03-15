package entity.RowMapping;

import entity.Role;
import util.RowMapperObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapping implements RowMapperObject {

    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        Role role = new Role();
        role.setId(rs.getInt("id"));
        role.setRoleName(rs.getString("role_name"));
        role.setCreateTime(rs.getString("create_time"));
        return role;
    }
}
