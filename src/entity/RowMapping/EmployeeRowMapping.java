package entity.RowMapping;

import entity.Employee;
import util.RowMapperObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapping implements RowMapperObject {
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setEmpNo(rs.getString("emp_no"));
        employee.setEmpName(rs.getString("emp_name"));
        employee.setEmpDept(rs.getString("emp_dept"));
        employee.setSex(rs.getString("sex"));
        employee.setEducation(rs.getString("education"));
        employee.setEmail(rs.getString("email"));
        employee.setPhone(rs.getString("phone"));
        employee.setEntryTime(rs.getString("entry_time"));
        employee.setCreateTime(rs.getString("create_time"));
        return employee;
    }
}
