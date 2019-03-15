package service.Impl;

import beanfactory.BeanFactory;
import dao.UserPrivilegesDao;
import entity.UserPrivileges;
import exception.PrivilegesException;
import service.UserPrivilegesService;
import util.Transaction;

import java.util.List;

public class UserPrivilegesServiceImpl implements UserPrivilegesService {

    private UserPrivilegesDao userPrivilegesDao = (UserPrivilegesDao) BeanFactory.getObject("userprivilegesdao");
    private Transaction transaction = (Transaction) BeanFactory.getObject("transaction");


    @Override
    public int countPrivileges(String roleName, String menuName) throws PrivilegesException{
        int count = userPrivilegesDao.countPrivilegesCondition(roleName, menuName);
        if(count == 0){
            throw new PrivilegesException("没有该条记录！");
        }
        return count;
    }

    @Override
    public List<UserPrivileges> listPrivilegesCondition(int page, String roleName, String menuName) {
        List<UserPrivileges> list = userPrivilegesDao.listPrivilegesCondition(page, roleName, menuName);
        return list;
    }

    @Override
    public int countUserPrivileges() {
        int count = userPrivilegesDao.countUserPrivileges();
        return count;

    }

    @Override
    public List<UserPrivileges> listLimitUserPrivileges(int page) {

        List<UserPrivileges> list  = userPrivilegesDao.listLimitUserPrivileges(page);
        return list;


    }

    public static void main(String[] args) {
        UserPrivilegesService userPrivilegesService = new UserPrivilegesServiceImpl();
        System.out.println(userPrivilegesService.listPrivilegesCondition(0,"dsaf","fdas"));
    }
}
