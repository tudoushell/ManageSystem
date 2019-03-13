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
    public User isUser(String username,String password) {
        try {
            transaction.start();
            User user = userDao.getUser(username,password);
            if(user != null){
                transaction.commit();
                return user;
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return  null;
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        System.out.println(userService.isUser("admin","admin"));
//        System.out.println(a);
    }
}
