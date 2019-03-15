package entity.RowMapping;

import entity.User;
import util.RowMapperObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapping implements RowMapperObject {
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserAccount(rs.getString("user_account"));
        user.setUserPwd(rs.getString("user_pwd"));
        user.setEmpNo(rs.getString("emp_no"));
        user.setEmpName(rs.getString("emp_name"));
        user.setRoleId(rs.getString("role_id"));
        user.setCreateTime(rs.getString("create_time"));
        return user;
    }
}
