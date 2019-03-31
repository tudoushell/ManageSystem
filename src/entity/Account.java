package entity;

/**
 * 帐户实体类
 */
public class Account {
    private int id;
    private String userAccount;
    private String empName;
    private String empNo;
    private String AccountStatus;
    private String roleName;

    public Account() {
        super();
    }

    public Account(int id, String userAccount, String empName, String empNo, String accountStatus, String roleName) {
        this.id = id;
        this.userAccount = userAccount;
        this.empName = empName;
        this.empNo = empNo;
        AccountStatus = accountStatus;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        AccountStatus = accountStatus;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userAccount='" + userAccount + '\'' +
                ", empName='" + empName + '\'' +
                ", empNo='" + empNo + '\'' +
                ", AccountStatus='" + AccountStatus + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
