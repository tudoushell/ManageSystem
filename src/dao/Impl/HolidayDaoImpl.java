package dao.Impl;

import dao.HolidayDao;
import entity.Holiday;
import entity.RowMapping.HolidayRowMapping;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HolidayDaoImpl implements HolidayDao {

    @Override
    public int getMaxId() {
        String sql = "SELECT max(id) FROM holiday;";
        int Count = (int)JDBCUtil.executeQueryData(sql);
        return Count;
    }

    @Override
    public boolean updateHoliday(Holiday holiday) {
        String sql = "UPDATE holiday set holiday_type=?,holiday_bz=?,start_time=?,end_time=?,holiday_status=?" +
                                     "WHERE holiday_no=?";
        int flag =  JDBCUtil.update(sql, holiday.getHolidayType(),
                                         holiday.getHolidayBz(),
                                         holiday.getStartTime(),
                                         holiday.getEndTime(),
                                         holiday.getHolidayStatus(),
                                         holiday.getHolidayNo());
        if (flag != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteHoliday(String holidayNo) {
        String sql = "DELETE from holiday WHERE holiday_no=?";
        int flag = JDBCUtil.update(sql, holidayNo);
        if (flag != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean saveHoliday(Holiday holiday) {
        String sql = "INSERT INTO holiday (holiday_no," +
                                           "holiday_user," +
                                            "holiday_type," +
                                            "holiday_bz," +
                                            "start_time," +
                                            "end_time," +
                                            "holiday_status," +
                                            "create_time) " +
                                            "values(?,?,?,?,?,?,?,curdate())";
        int flag = JDBCUtil.update(sql,holiday.getHolidayNo(),
                                        holiday.getHolidayUser(),
                                        holiday.getHolidayType(),
                                        holiday.getHolidayBz(),
                                        holiday.getStartTime(),
                                        holiday.getEndTime(),
                                        holiday.getHolidayStatus());
        if (flag != 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Holiday> listHolidayByConditionOrAll(String[] columnName, boolean flag, Object... args) {
        String [] copyColumnName = {columnName[0], columnName[1], columnName[2]};
        String sql = "SELECT " +
                            "id," +
                            "holiday_no," +
                            "holiday_user," +
                            "holiday_type," +
                            "holiday_bz," +
                            "start_time," +
                            "end_time," +
                            "holiday_status," +
                            "create_time" +
                            " FROM v_holiday WHERE 1=1" ;
        for (int i = 0; i < copyColumnName.length; i++) {
            if ("".equals(copyColumnName[i])){
                copyColumnName[i] = "1";
                args[i] = "1";
            }
            sql += " AND " + copyColumnName[i] + " LIKE ?";
        }
        if (flag){
            sql += "LIMIT ?,3";
        }
        List<Object> holidays = JDBCUtil.executeQuery(sql, new HolidayRowMapping(), args);
        List<Holiday> listHoliday = new ArrayList<>();
        if (holidays != null){
            Iterator<Object> it = holidays.iterator();
            while (it.hasNext()){
                listHoliday.add((Holiday) it.next());
            }
            return listHoliday;
        }
        return null;
    }

    public static void main(String[] args) {
        HolidayDao holidayDao = new HolidayDaoImpl();
//        System.out.println(holidayDao.listHolidayByConditionOrAll(new String[]{"","",""},false,"","",""));
        Holiday holiday = new Holiday();
        holiday.setHolidayNo("QJ124");
        holiday.setHolidayUser("haha");
        holiday.setStartTime("2019-04-12");
        holiday.setEndTime("2019-4-20");
        holiday.setHolidayBz("回家吃饭");
        holiday.setHolidayStatus("1");
        holiday.setHolidayType("5");
        System.out.println(holidayDao.updateHoliday(holiday));
//        holidayDao.saveHoliday(holiday);

    }

}
