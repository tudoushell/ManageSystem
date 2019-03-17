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
    public List<String> listRoleIdPrivileges(int roleId) {
        List<String> userPrivileges = userPrivilegesDao.listRoleIdPrivileges(roleId);
        return userPrivileges;
    }

    @Override
    public String getMenuId(String menuName) throws  PrivilegesException{
        String result = userPrivilegesDao.getMenuId(menuName);
        if(result != null){
            return result;
        }else {
            throw new PrivilegesException("请选择正确的选项");
        }
    }

    @Override
    public int getRoleId(String roleName) throws  PrivilegesException{
        int result = userPrivilegesDao.getRoleId(roleName);
        if(result != 0){
            return result;
        }else {
            throw new PrivilegesException("请选择正确的选项");
        }

    }

    @Override
    public UserPrivileges getRoleIdAndMenuId(String roleName, String menuName) throws PrivilegesException{
        UserPrivileges user = userPrivilegesDao.getRoleIdAndMenuId(roleName,menuName);
        if(user == null){
            throw new PrivilegesException("请选择正确的角色名和菜单名!");
        }
        return user;
    }

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

    public static void main(String[] args) throws PrivilegesException {
        UserPrivilegesService userPrivilegesService = new UserPrivilegesServiceImpl();
        System.out.println(userPrivilegesService.getMenuId("权限管理"));
        System.out.println(userPrivilegesService.getRoleId("普通用户"));
        System.out.println(userPrivilegesService.listRoleIdPrivileges(1));

    }
}
