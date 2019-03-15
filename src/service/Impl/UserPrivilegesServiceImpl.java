package service.Impl;

import beanfactory.BeanFactory;
import dao.UserPrivilegesDao;
import entity.UserPrivileges;
import service.UserPrivilegesService;
import util.Transaction;

import java.util.List;

public class UserPrivilegesServiceImpl implements UserPrivilegesService {

    private UserPrivilegesDao userPrivilegesDao = (UserPrivilegesDao) BeanFactory.getObject("userprivilegesdao");
    private Transaction transaction = (Transaction) BeanFactory.getObject("transaction");


    @Override
    public int countUserPrivileges() {
        int count = userPrivilegesDao.countUserPrivileges();
        if(count != 0){
            return count;
        }
        return 0;
    }

    @Override
    public List<UserPrivileges> listLimitUserPrivileges(int page) {
        List<UserPrivileges> list  = userPrivilegesDao.listLimitUserPrivileges(page);
        if(list != null){
            return list;
        }
        return null;
    }
}
