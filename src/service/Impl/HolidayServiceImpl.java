package service.Impl;

import beanfactory.BeanFactory;
import dao.HolidayDao;
import entity.Holiday;
import exception.HolidayException;
import service.HolidayService;
import util.Transaction;

import java.sql.SQLException;
import java.util.List;

public class HolidayServiceImpl implements HolidayService {
    private HolidayDao holidayDao = (HolidayDao) BeanFactory.getObject("holidaydao");
    private Transaction transaction  = (Transaction) BeanFactory.getObject("transaction");

    @Override
    public boolean deleteHolidayByHolidayNo(String holidayNo) {
        try {
            transaction.start();
            boolean flag = holidayDao.deleteHoliday(holidayNo);
            if (flag){
                transaction.commit();
                return true;
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Holiday getHolidayByHolidayNo(String holidayNo) {
        return holidayDao.getHolidayByHolidayNo(holidayNo);
    }

    @Override
    public List<Holiday> listHolidayByConditionOrAll(String[] columnName, boolean flag, Object... args) throws HolidayException {
        List<Holiday> listHoliday = holidayDao.listHolidayByConditionOrAll(columnName,flag, args);
        if (listHoliday == null){
            throw new HolidayException("没有请假信息");
        }
        return listHoliday;
    }
}
