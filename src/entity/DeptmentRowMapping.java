package entity;

import util.RowMapperObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptmentRowMapping implements RowMapperObject {
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
           Department dept = new Department();
           dept.setDeptId(rs.getString("dept_id"));
           dept.setDeptName(rs.getString("dept_name"));
           dept.setDeptLoc(rs.getString("dept_loc"));
           dept.setDeptLeader(rs.getString("dept_leader"));
           return  dept;
    }
}
