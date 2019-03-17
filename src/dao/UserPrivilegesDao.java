package dao;

import entity.UserPrivileges;

import java.util.List;

public interface UserPrivilegesDao {

    /**
     * 列出角色的权限
     * @return
     */
    List<String> listRoleIdPrivileges(int roleId);
    /**
     * 根据菜单名来获取菜单id
     * @param menuName
     * @return
     */
    String getMenuId(String menuName);

    /**
     * 通过角色名来获取roleId
     * @param roleName
     * @return
     */
    int getRoleId(String roleName);

    /**
     * 根据角色名和菜单名来获取id
     * @param roleName
     * @param menuName
     * @return
     */
    UserPrivileges getRoleIdAndMenuId(String roleName, String menuName);
    /**
     * 根据角色和菜单名的条件来统计数量
     * @param roleName
     * @param menuName
     * @return
     */
    int countPrivilegesCondition(String roleName, String menuName);

    /**
     * 根据角色和菜单名条件来列出信息
     * @param page
     * @param roleName
     * @param menuName
     * @return
     */
    List<UserPrivileges> listPrivilegesCondition(int page, String roleName, String menuName);
    /**
     * 统计用户权限的数量
     * @return
     */
    int countUserPrivileges();

    /**
     * 分页显示用户权限
     * @return
     */
    List<UserPrivileges> listLimitUserPrivileges(int page);
}
