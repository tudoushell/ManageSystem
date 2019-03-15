package entity.RowMapping;

import entity.Reimburse;
import util.RowMapperObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimburseRowMapping implements RowMapperObject {

    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        Reimburse reimburse = new Reimburse();
        reimburse.setReimNo(rs.getString("reim_no"));
        reimburse.setReimName(rs.getString("reim_name"));
        reimburse.setReimType(rs.getString("reim_type"));
        reimburse.setReimMoney(rs.getDouble("reim_money"));
        reimburse.setCreateTime(rs.getString("reim_create_time"));
        reimburse.setReimStatus(rs.getString("reim_status"));
        reimburse.setReimAbstract(rs.getString("reim_abstract"));
        return reimburse;
    }
}
