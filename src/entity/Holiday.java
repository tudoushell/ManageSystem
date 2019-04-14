package entity;

/**
 * 请假的实体类
 */
public class Holiday {
    /**
     * id
     */
    private int id;
    /**
     * 请假编号
     */
    private String holidayNo;
    /**
     * 请假人的姓名
     */
    private String holidayUser;
    /**
     * 请假的类型
     */
    private String holidayType;
    /**
     * 请假事由
     */
    private String holidayBz;
    /**
     * 请假开始时间
     */
    private String startTime;
    /**
     * 请假结束时间
     */
    private String endTime;
    /**
     * 请假的状态
     */
    private String holidayStatus;
    /**
     * 创建时间
     */
    private String createTime;

    public Holiday() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHolidayNo() {
        return holidayNo;
    }

    public void setHolidayNo(String holidayNo) {
        this.holidayNo = holidayNo;
    }

    public String getHolidayUser() {
        return holidayUser;
    }

    public void setHolidayUser(String holidayUser) {
        this.holidayUser = holidayUser;
    }

    public String getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(String holidayType) {
        this.holidayType = holidayType;
    }

    public String getHolidayBz() {
        return holidayBz;
    }

    public void setHolidayBz(String holidayBz) {
        this.holidayBz = holidayBz;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getHolidayStatus() {
        return holidayStatus;
    }

    public void setHolidayStatus(String holidayStatus) {
        this.holidayStatus = holidayStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", holidayNo='" + holidayNo + '\'' +
                ", holidayUser='" + holidayUser + '\'' +
                ", holidayType='" + holidayType + '\'' +
                ", holidayBz='" + holidayBz + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", holidayStatus='" + holidayStatus + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
