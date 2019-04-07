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

    @Override
    public User getUserByAccount(String account) {
        return userDao.getUserByAccount(account);
    }

    @Override
    public User getUserByEmpNo(String empNo) {
        return userDao.getUserByEmpNo(empNo);
    }

    @Override
    public Boolean saveUser(User user) {
        try {
            transaction.start();
            if (userDao.saveUser(user)){
                transaction.commit();
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
        return false;
    }

    @Override
    public Boolean updateUserByEmpNo(User user) {
        try {
            transaction.start();
            Boolean flag = userDao.updataUserByEmpNo(user);
            if (flag){
                transaction.commit();
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
        return false;
    }

    @Override
    public Boolean deleteUserByEmpNo(String empNo) {
        try {
            transaction.start();
            boolean flag = userDao.deleteUserByEmpNo(empNo);
            if (flag){
                transaction.commit();
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
        return false;
    }

    @Override
    public User getUserByRoleId(String roleId) {
        User user = userDao.getUserByRoleId(roleId);
        return user;
    }

    @Override
    public boolean updateUser(String username, String password) {
        try {
            transaction.start();
           boolean flag = userDao.updateUser(username,password);
           if(flag){
               transaction.commit();
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
        return false;
    }

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
        System.out.println(userService.getUserByRoleId("1"));
//        System.out.println(a);
    }
}
