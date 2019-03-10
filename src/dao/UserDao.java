package dao;

import entity.User;

public interface UserDao {
    /**
     * 根据用户名来验证
     * @param username
     */
    boolean getUser(String username , String password);
}
