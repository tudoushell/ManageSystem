package dao.Impl;

import beanfactory.BeanFactory;
import dao.UserDao;
import entity.User;
import entity.UserRowMapping;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    /**
     * 更改用户密码
     * @param userAccount
     * @param password
     * @return
     */
    @Override
    public boolean updateUser(String userAccount, String password) {
        String sql = "UPDATE user set user_pwd=? WHERE user_account=?";
        int flag = JDBCUtil.update(sql,password,userAccount);
        if(flag != 0){
            return true;
        }
        return false;
    }

    /**
     * 通过用户名来获取信息
     * @param username
     * @return
     */
    @Override
    public User getUser(String username,String password) {
        String sql = "SELECT * FROM user WHERE user_account=? AND user_pwd=?";
        User user = new User();
        List<Object> list =  JDBCUtil.executeQuery(sql, new UserRowMapping(),username,password);
        if(list != null ){
            user = (User) list.get(0);
            return user;
        }
        return null;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.updateUser("admin","admin"));
    }
}
