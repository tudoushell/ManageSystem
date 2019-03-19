package servlet;

import beanfactory.BeanFactory;
import service.RoleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoleAction {
    private RoleService roleService = (RoleService) BeanFactory.getObject("roleservice");

    /**
     * 列出角色管理
     * @param request
     * @param response
     * @return
     */
    public String doListRole(HttpServletRequest request, HttpServletResponse response){

        return null;
    }
}
