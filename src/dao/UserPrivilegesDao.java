package dao;

import entity.UserPrivileges;

import java.util.List;

public interface UserPrivilegesDao {

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
