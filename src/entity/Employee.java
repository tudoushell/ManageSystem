package entity;

public class Employee {

    private String empNo;
    private String empName;
    private String empDept;
    private String sex;
    private String education;
    private String email;
    private String phone;
    private String entryTime;
    private String createTime;

    public Employee() {
        super();
    }

    public Employee(String empNo,String empName, String empDept, String sex, String education, String email, String phone, String entryTime, String createTime) {
        this.empNo = empNo;
        this.empName = empName;
        this.empDept = empDept;
        this.sex = sex;
        this.education = education;
        this.email = email;
        this.phone = phone;
        this.entryTime = entryTime;
        this.createTime = createTime;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
                ", empDept='" + empDept + '\'' +
                ", sex='" + sex + '\'' +
                ", education='" + education + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", entryTime='" + entryTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
