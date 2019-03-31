package entity.RowMapping;

import entity.Account;
import util.RowMapperObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapping implements RowMapperObject {
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setUserAccount(rs.getString("user_account"));
        account.setEmpName(rs.getString("emp_name"));
        account.setEmpNo(rs.getString("emp_no"));
        account.setAccountStatus(rs.getString("account_status"));
        account.setRoleName(rs.getString("role_name"));
        return account;
    }
}
