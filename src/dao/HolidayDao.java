package dao;

import entity.Holiday;

import java.util.List;

public interface HolidayDao {
    /**
     * 获取最大的id号
     * @return
     */
    int getMaxId();
    /**
     * 修改请假信息
     * @param holiday
     * @return
     */
    boolean updateHoliday(Holiday holiday);
    /**
     * 根据请假编号来删除信息
     * @param holidayNo
     * @return
     */
    boolean deleteHoliday(String holidayNo);

    /**
     * 添加请假信息
     * @param holiday
     * @return
     */
    boolean saveHoliday(Holiday holiday);
    /**
     * 通过条件列出请假信息或全部信息
     * @param columnName
     * @param flag
     * @param args
     * @return
     */
    List<Holiday> listHolidayByConditionOrAll(String[] columnName, boolean flag, Object ... args );
}
