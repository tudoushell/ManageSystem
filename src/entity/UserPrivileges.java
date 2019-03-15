package entity;

public class UserPrivileges {
    private int id;
    private int roleId;
    private String roleName;
    private String menuId;
    private String menuName;

    public UserPrivileges() {
        super();
    }

    public UserPrivileges(int id, int roleId, String roleName, String menuId, String menuName) {
        this.id = id;
        this.roleId = roleId;
        this.roleName = roleName;
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "UserPrivileges{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
