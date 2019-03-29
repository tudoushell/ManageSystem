package dao;

import entity.User;

import java.util.List;

public interface UserDao {

    /**
     * 通过roleId来获取用户信息
     * @param roleId
     * @return
     */
    User getUserByRoleId(String roleId);
    /**
     * 修改用户信息
     * @param userAccount
     * @param password
     * @return
     */
    boolean updateUser(String userAccount , String password);

    /**
     * 根据用户名来验证
     * @param username
     */
    User getUser(String username , String password);
}
