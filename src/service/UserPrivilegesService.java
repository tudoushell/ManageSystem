package service;

import entity.UserPrivileges;

import java.util.List;

public interface UserPrivilegesService {

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
