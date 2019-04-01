package dao;

import entity.User;

import java.util.List;

public interface UserDao {

    /**
     * 根据员工号来删除信息
     * @param empNo
     * @return
     */
    Boolean deleteUserByEmpNo(String empNo);
    /**
     * 通过条件来查询的所有用户信息
     * 或者列出所有的用户信息
     * @param columnName 数据库的列名
     * @param flag 用于是否进行分页
     * @param args 参数值
     * @return
     */
    List<User> listUserByConditionOrAll(String[] columnName, boolean flag ,Object ... args);

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
