package entity;

import util.RowMapperObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapping implements RowMapperObject {
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserName(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
