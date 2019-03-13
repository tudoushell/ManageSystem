package dao;

import entity.User;

import java.util.List;

public interface UserDao {



    /**
     * 根据用户名来验证
     * @param username
     */
    User getUser(String username , String password);
}
