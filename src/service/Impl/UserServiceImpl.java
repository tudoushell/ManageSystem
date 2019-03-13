package service.Impl;

import beanfactory.BeanFactory;
import dao.UserDao;
import entity.User;
import service.UserService;
import util.Transaction;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao = (UserDao) BeanFactory.getObject("userdao");
    private Transaction transaction = (Transaction) BeanFactory.getObject("transaction");

    /**
     * 从前台获取用户名和密码来进行判断
     * @param username
     * @param password
     * @return
     */

    @Override
    public boolean isUser(String username,String password) {
        try {
            transaction.start();
            boolean flag = userDao.getUser(username.trim(),password.trim());
            transaction.commit();
            if(flag){
                return true;
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return  false;
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        boolean a = userService.isUser(" admin  ","admin");
        System.out.println(a);
    }
}
