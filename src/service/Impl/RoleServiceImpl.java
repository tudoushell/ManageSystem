package service.Impl;

import beanfactory.BeanFactory;
import dao.RoleDao;
import entity.Role;
import service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao = (RoleDao) BeanFactory.getObject("roledao");

    @Override
    public List<Role> listRole() {
        List<Role> listroles = roleDao.listRole();
        if(listroles != null){
            return listroles;
        }
        return null;
    }

    public static void main(String[] args) {
        RoleService roleService = (RoleService) BeanFactory.getObject("roleservice");
        System.out.println(roleService.listRole());
    }
}
