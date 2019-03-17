package service;

import entity.UserPrivileges;
import exception.PrivilegesException;

import java.util.List;

public interface UserPrivilegesService {

    /**
     * 根据角色id来列出权限
     * @param roleId
     * @return
     */
    List<String> listRoleIdPrivileges(int roleId);
    /**
     * 根据菜单名来获取id
     * @param menuName
     * @return
     */
    String getMenuId(String menuName) throws  PrivilegesException;

    /**
     * 根据角色名来获取id
     * @param roleName
     * @return
     */
    int getRoleId(String roleName) throws  PrivilegesException;

    /**
     * 根据角色名和菜单名来获取id
     * @param roleName
     * @param menuName
     * @return
     */
    UserPrivileges getRoleIdAndMenuId(String roleName, String menuName) throws PrivilegesException;

    /**
     * 统计按条件来查询的数量
     * @param roleName
     * @param menuName
     * @return
     */
    int countPrivileges(String roleName, String menuName) throws PrivilegesException;

    /**
     * 根据条件来进行查询分页
     * @param page
     * @param roleName
     * @param menuName
     * @return
     */
    List<UserPrivileges> listPrivilegesCondition(int page, String roleName, String menuName);
    /**
     * 统计用户权限数量
     * @return
     */
    int countUserPrivileges();

    /**
     * 分页显示用户权限
     * @return
     */
    List<UserPrivileges> listLimitUserPrivileges(int page);
}
