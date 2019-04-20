package service;

import entity.Holiday;
import exception.HolidayException;

import java.util.List;

public interface HolidayService {
    /**
     * 获取订单的最大的id
     * @return
     */
    int getMaxId();
    /**
     * 添加请假信息
     * @param holiday
     * @return
     */
    boolean saveHoliday(Holiday holiday);
    /**
     * 根据请假单号来删除信息
     * @param holidayNo
     * @return
     */
    boolean deleteHolidayByHolidayNo(String holidayNo);

    /**
     * 根据请假单号来获取信息
     * @param holidayNo
     * @return
     */
    Holiday getHolidayByHolidayNo(String holidayNo);

    /**
     * 根据条件来列出请假信息或者列出所有信息
     * @param columnName
     * @param flag
     * @param args
     * @return
     */
    List<Holiday> listHolidayByConditionOrAll(String[] columnName, boolean flag, Object ... args) throws HolidayException;
}
