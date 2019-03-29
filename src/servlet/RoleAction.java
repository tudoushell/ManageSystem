package servlet;

import beanfactory.BeanFactory;
import entity.Role;
import exception.RoleException;
import service.RoleService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

public class RoleAction {
    private RoleService roleService = (RoleService) BeanFactory.getObject("roleservice");
    private UserService userService = (UserService) BeanFactory.getObject("userservice");
    /**
     * 添加角色信息
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    public String doSaveRole(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String roleName = request.getParameter("roleName");
        //如果角色名已存，则不添加
        if(roleService.getRoleByName(roleName) != null){
            request.setAttribute("result", "该角色名已存在！");
            request.setAttribute("method", "addRole.jsp");
            return "fail";
        }
        roleService.saveRole(new Role(1,roleName,new Date(new java.util.Date().getTime()).toString()));
        request.setAttribute("result", "添加成功！");
        request.setAttribute("method", "listRole.do");
        return "success";
    }


    /**
     *
     * 更新角色信息
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    public  String doUpdateRole(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String roleName = request.getParameter("roleName");
        Role role = (Role) request.getSession().getAttribute("role");
        try {
            roleService.updateRole(new Role(role.getId(),roleName,role.getCreateTime()));
        } catch (RoleException e) {
            request.setAttribute("result", e.getErrorMsg());
            request.setAttribute("method", "getRole.do?roleId=" + role.getId());
            return "fail";
        }
        request.setAttribute("result", "修改成功！");
        request.setAttribute("method", "listRole.do");
        return "success";
    }
    /**
     * 获取角色信息
     * @return
     */
    public String getRole(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("roleId");
        int roleId = Integer.parseInt(id);
        Role role = roleService.getRoleById(roleId);
        request.getSession().setAttribute("role",role);
        return "success";
    }

    /**
     * 删除角色信息
     * @return
     */
    public String deleteRole(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("roleId");
        int roleId = Integer.parseInt(id);
        if(userService.getUserByRoleId(id) != null){
            request.setAttribute("result", "该角色下有员工，禁止删除");
            request.setAttribute("method", "listRole.do");
            return "fail";
        }
        if(roleService.deleteRole(roleId)) {
            request.setAttribute("result", "删除成功！");
            request.setAttribute("method", "listRole.do");
            return "success";
        }
        return null;
    }
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
