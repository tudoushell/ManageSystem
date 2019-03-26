package service.Impl;

import beanfactory.BeanFactory;
import dao.RoleDao;
import entity.Role;
import exception.RoleException;
import service.RoleService;
import util.Transaction;

import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao = (RoleDao) BeanFactory.getObject("roledao");
    private Transaction transaction  = (Transaction) BeanFactory.getObject("transaction");
    @Override
    public boolean updateRole(Role role) {
        try {
            transaction.start();
            boolean flag = roleDao.updateRole(role);
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
    public boolean deleteRole(int roleId) {
        try {
            transaction.start();
            boolean flag = roleDao.deleteRole(roleId);
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
    public List<Role> listRole() throws RoleException {
        List<Role> listroles = roleDao.listRole();
        if(listroles != null){
            return listroles;
        }else {
            throw new RoleException("没有数据！");
        }
    }

    public static void main(String[] args) {
        RoleService roleService = (RoleService) BeanFactory.getObject("roleservice");
        System.out.println(roleService.updateRole(new Role(4,"haha","2019-03-26")));
//        System.out.println(roleService.listRole());
    }
}
