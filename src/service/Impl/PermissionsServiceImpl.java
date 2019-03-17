package service.Impl;

import beanfactory.BeanFactory;
import dao.PermissionsDao;
import entity.Permissions;
import service.PermissionsService;
import util.Transaction;

import java.sql.SQLException;

public class PermissionsServiceImpl implements PermissionsService {
    private PermissionsDao permissionsDao = (PermissionsDao) BeanFactory.getObject("permissionsdao");
    private Transaction transaction  = (Transaction) BeanFactory.getObject("transaction");

    @Override
    public boolean updatePermissions(int id, String roleId, String menuId) {
        try {
            transaction.start();
            boolean flag = permissionsDao.updatePermissions(id,roleId,menuId);
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

    @Override
    public boolean deletePerm(String roleId, String menuId) {
        try {
            transaction.start();
            boolean flag = permissionsDao.deletePermByRoleAndMenu(roleId,menuId);
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
    public boolean savePermissions(Permissions perm) {
        try {
            transaction.start();
            boolean flag = permissionsDao.savePermissions(perm);
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
