package entity;

public class Permissions {

    private int id;
    private String roleId;
    private String menuId;
    private String createTime;

    public Permissions() {
        super();
    }

    public Permissions(String roleId, String menuId, String createTime, int id) {
        this.roleId = roleId;
        this.menuId = menuId;
        this.createTime = createTime;
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "id=" + id +
                ", roleId='" + roleId + '\'' +
                ", menuId='" + menuId + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
