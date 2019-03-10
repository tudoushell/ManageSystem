package entity;

public class Department {
    private String deptId;
    private String deptName;
    private String deptLoc;
    private String deptLeader;

    public Department() {
        super();
    }

    public Department(String deptId, String deptName, String deptLoc, String deptLeader) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptLoc = deptLoc;
        this.deptLeader = deptLeader;
    }

    public String getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDeptLoc() {
        return deptLoc;
    }

    public String getDeptLeader() {
        return deptLeader;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setDeptLoc(String deptLoc) {
        this.deptLoc = deptLoc;
    }

    public void setDeptLeader(String deptLeader) {
        this.deptLeader = deptLeader;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptLoc='" + deptLoc + '\'' +
                ", deptLeader='" + deptLeader + '\'' +
                '}';
    }
}
