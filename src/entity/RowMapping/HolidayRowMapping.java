package entity.RowMapping;

import entity.Holiday;
import util.RowMapperObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HolidayRowMapping implements RowMapperObject {
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        Holiday holiday = new Holiday();
        holiday.setId(rs.getInt("id"));
        holiday.setHolidayNo(rs.getString("holiday_no"));
        holiday.setHolidayUser(rs.getString("holiday_user"));
        holiday.setHolidayType(rs.getString("holiday_type"));
        holiday.setHolidayBz(rs.getString("holiday_bz"));
        holiday.setStartTime(rs.getString("start_time"));
        holiday.setEndTime(rs.getString("end_time"));
        holiday.setHolidayStatus(rs.getString("holiday_status"));
        holiday.setCreateTime(rs.getString("create_time"));
        return holiday;
    }
}
