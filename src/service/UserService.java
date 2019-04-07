package service;

import entity.User;

public interface UserService {
    /**
     * 通过帐号来获取信息
     * @param account
     * @return
     */
    User getUserByAccount(String account);

    /**
     * 通过员工号来获取信息
     * @param empNo
     * @return
     */
    User getUserByEmpNo(String empNo);
    /**
     * 添加用户信息
     * @param user
     * @return
     */
    Boolean saveUser(User user);

    /**
     * 通过员工编号来修改员工信息
     * @param user
     * @return
     */
    Boolean updateUserByEmpNo(User user);
    /**
     * 通过员工编号来删除员工信息
     * @param empNo
     * @return
     */
    Boolean deleteUserByEmpNo(String empNo);
    /**
     * 通过roleid来获取信息
     * @param roleId
     * @return
     */
    User getUserByRoleId(String roleId);

    /**
     * 修改用户密码
     * @param username
     * @param password
     * @return
     */
    boolean updateUser(String username,String password);
    /**
     * 判断用户密码是否正确
     * @param username
     * @param password
     * @return
     */
    User isUser(String username, String password);
}
