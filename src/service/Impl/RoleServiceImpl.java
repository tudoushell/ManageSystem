package service.Impl;

import beanfactory.BeanFactory;
import dao.RoleDao;
import entity.Role;
import exception.RoleException;
import service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao = (RoleDao) BeanFactory.getObject("roledao");

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
//        System.out.println(roleService.listRole());
    }
}
