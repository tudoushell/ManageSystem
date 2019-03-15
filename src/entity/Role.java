package entity;

public class Role {
    private int id;
    private String roleName;
    private String createTime;

    public Role() {
        super();
    }

    public Role(int id, String roleName, String createTime) {
        this.id = id;
        this.roleName = roleName;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
