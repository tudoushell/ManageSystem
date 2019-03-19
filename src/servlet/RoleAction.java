package servlet;

import beanfactory.BeanFactory;
import entity.Role;
import exception.RoleException;
import service.RoleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class RoleAction {
    private RoleService roleService = (RoleService) BeanFactory.getObject("roleservice");

    /**
     * 列出角色管理
     * @param request
     * @param response
     * @return
     */
    public String doListRole(HttpServletRequest request, HttpServletResponse response){
        try {
            List<Role> listRole = roleService.listRole();
            request.setAttribute("listRole",listRole);
            return "success";
        } catch (RoleException e) {
            return "fail";
        }
    }
}
