package service.Impl;

import beanfactory.BeanFactory;
import dao.PermissionsDao;
import service.PermissionsService;
import util.Transaction;

import java.sql.SQLException;

public class PermissionsServiceImpl implements PermissionsService {
    private PermissionsDao permissionsDao = (PermissionsDao) BeanFactory.getObject("permissionsdao");
    private Transaction transaction  = (Transaction) BeanFactory.getObject("transaction");

    @Override
    public boolean deletePermissions(int id) {
        try {
            transaction.start();
            boolean flag = permissionsDao.deletePermissions(id);
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
}
