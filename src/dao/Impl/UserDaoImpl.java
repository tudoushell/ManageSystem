package dao.Impl;

import beanfactory.BeanFactory;
import dao.UserDao;
import entity.User;
import entity.UserRowMapping;
import util.JDBCUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {

    /**
     * 通过用户名来获取信息
     * @param username
     * @return
     */
    @Override
    public boolean getUser(String username,String password) {
        String sql = "SELECT * FROM user WHERE username=? AND password=?";
        List<Object> list =  JDBCUtil.executeQuery(sql, new UserRowMapping(),username,password);
        if(list != null ){
            return true;
        }
        return false;
    }

}
