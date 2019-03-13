package entity;

public class Reimburse {

    private String reimNo;
    private String reimName;
    private String reimType;
    private double reimMoney;
    private String createTime;
    private String reimStatus;
    private String reimAbstract;

    public Reimburse() {
        super();
    }

    public String getReimNo() {
        return reimNo;
    }

    public void setReimNo(String reimNo) {
        this.reimNo = reimNo;
    }

    public String getReimName() {
        return reimName;
    }

    public void setReimName(String reimName) {
        this.reimName = reimName;
    }

    public String getReimType() {
        return reimType;
    }

    public void setReimType(String reimType) {
        this.reimType = reimType;
    }

    public double getReimMoney() {
        return reimMoney;
    }

    public void setReimMoney(double reimMoney) {
        this.reimMoney = reimMoney;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getReimStatus() {
        return reimStatus;
    }

    public void setReimStatus(String reimStatus) {
        this.reimStatus = reimStatus;
    }

    public String getReimAbstract() {
        return reimAbstract;
    }

    public void setReimAbstract(String reimAbstract) {
        this.reimAbstract = reimAbstract;
    }

    @Override
    public String toString() {
        return "Reimburse{" +
                "reimNo='" + reimNo + '\'' +
                ", reimName='" + reimName + '\'' +
                ", reimType='" + reimType + '\'' +
                ", reimMoney=" + reimMoney +
                ", createTime='" + createTime + '\'' +
                ", reimStatus='" + reimStatus + '\'' +
                ", reimAbstract='" + reimAbstract + '\'' +
                '}';
    }
}
