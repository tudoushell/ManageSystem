package entity;

/**
 * 帐户实体类
 */
public class Account {
    private int id;
    private String userAccount;
    private String empName;
    private String empNo;
    private String accountStatus;
    private String roleName;

    public Account() {
        super();
    }

    public Account(int id, String userAccount, String empName, String empNo, String accountStatus, String roleName) {
        this.id = id;
        this.userAccount = userAccount;
        this.empName = empName;
        this.empNo = empNo;
        this.accountStatus = accountStatus;
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
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
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
                ", accountStatus='" + accountStatus + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
