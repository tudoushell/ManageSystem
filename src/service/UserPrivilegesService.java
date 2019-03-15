package service;

import entity.UserPrivileges;
import exception.PrivilegesException;

import java.util.List;

public interface UserPrivilegesService {

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
