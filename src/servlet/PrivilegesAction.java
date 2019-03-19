package servlet;

import beanfactory.BeanFactory;
import entity.*;
import exception.PrivilegesException;
import exception.RoleException;
import service.MenuService;
import service.PermissionsService;
import service.RoleService;
import service.UserPrivilegesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import static servlet.EmpAction.divisionPage;

public class PrivilegesAction {
    private UserPrivilegesService userPrivileges = (UserPrivilegesService) BeanFactory.getObject("userprivilegesservice");
    private RoleService roleService = (RoleService) BeanFactory.getObject("roleservice");
    private MenuService menuService = (MenuService) BeanFactory.getObject("menuservice");
    private PermissionsService permService = (PermissionsService) BeanFactory.getObject("permissionsservice");

    /**
     * 检查用户对菜单的权限
     * @param request
     * @param response
     * @return
     */
    public  String  doCheckPrivileges(HttpServletRequest request, HttpServletResponse response){
          User user = (User) request.getSession().getAttribute("user");
          //获取用户的权限
        int roleId = Integer.parseInt(user.getRoleId());
        List<String> menuList = userPrivileges.listRoleIdPrivileges(roleId);
        System.out.println(menuList);
        request.setAttribute("menuList", menuList);
        return null;
    }
    /**
     * 修改角色权限
     * 1.先获取要修改的角色的权限id，对permissions进行修改
     * 2. 再获取角色名和菜单名，从user_perivileges表中对应的id
     * 3. 再根据id来修改角色名id和菜单名id
     * @return
     */
    public String doUpdatePerm(HttpServletRequest request, HttpServletResponse response)
            throws PrivilegesException, UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");
        String id = (String) request.getSession().getAttribute("id");
        int ids = Integer.parseInt(id);
        String roleName = request.getParameter("roleName");
        String menuName = request.getParameter("menuName");

        int roleId = userPrivileges.getRoleId(roleName);
        String roleIds = String.valueOf(roleId);
        String menuId = userPrivileges.getMenuId(menuName);
        permService.updatePermissions(ids, roleIds,menuId);
        request.setAttribute("result","修改成功！");
        request.setAttribute("method", "listPrivileges.do?page=1");
        return "success";
    }


    /**
     * 获取权限信息
     * @param request
     * @param response
     * @return
     */
    public String doGetPerm(HttpServletRequest request, HttpServletResponse response){
        String roleId = request.getParameter("roleId");
        String menuId = request.getParameter("menuId");
        String id = request.getParameter("id");
        request.setAttribute("roleId", roleId);
        request.setAttribute("menuId", menuId);
        request.getSession().setAttribute("id",id);
        return "success";
    }


    /*
        添加权限步骤
        先从视图中获取角色和菜单的id值，
        然后再根据角色和菜单id写入permission表中
        先去判断角色和菜单的id是否存在，如存在则删除，后添加
     */
    public String doAddPrivileges(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        //获取角色名和菜单名
        String roleName = request.getParameter("roleName");
        String menuName = request.getParameter("menuName");
        System.out.println(roleName+menuName);
        //从视图表中获取角色名和菜单名对应的id
        //如果没有角色名和菜单名则抛出异常
        int roleId = 0;
        String menuId = null;
        try {
            roleId =  userPrivileges.getRoleId(roleName);
            menuId = userPrivileges.getMenuId(menuName);
        } catch (PrivilegesException e) {
            request.setAttribute("result",e.getErrorMsg());
            request.setAttribute("method","addPermission.jsp");
            return "fail";
        }
        String roleIds = String.valueOf(roleId);
        System.out.println("roldid: " + roleId + " menuid " + menuId);
        //删除该角色的权限，防止添加时重复
        permService.deletePerm(roleIds,menuId);
        //进行添加
        Permissions perm = new Permissions(12,roleIds,menuId,new Date(new java.util.Date().getTime()).toString());
        permService.savePermissions(perm);
        request.setAttribute("result","添加成功！");
        request.setAttribute("method","listPrivileges.do?page=1");
        return "success";
    }

    /**
     * 删除角色权限
     * @param request
     * @param response
     * @return
     */
    public String doDelPrivileges(HttpServletRequest request, HttpServletResponse response){
        //获取删除的id
        int id = Integer.parseInt(request.getParameter("id"));
        boolean flag = permService.deletePermissions(id);
        if (flag){
            request.setAttribute("result","删除成功！");
            request.setAttribute("method","listPrivileges.do?page=1");
            return "success";
        }
        return "fail";
    }
    /**
     * 1.根据条件来列出所有角色权限
     * 2.列出所有的角色权限
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    public String dolistPrivileges(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
            request.setCharacterEncoding("utf-8");
            String roleName = request.getParameter("roleName");
            if(roleName.length() > 0){
                return listPrivilegesByCondition(request, response);
            }else {
                return  dolist(request,response);
            }
    }

    /**
     * 根据条件来列出权限信息
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    public String listPrivilegesByCondition(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {

            request.setCharacterEncoding("utf-8");
            //为角色和菜单的下拉框设置值
//            List<Role> listRole = roleService.listRole();
//            request.setAttribute("listRole",listRole);
//            List<Menu> listMenu = menuService.listMenu();
//            request.setAttribute("listMenu",listMenu);
            //获取条件值
            String roleName = request.getParameter("roleName");
            String menuName = request.getParameter("menuName");
            //每页显示的条数
            int COUNT = 3;
            //用户权限页数
            int page = Integer.parseInt(request.getParameter("page"));
            //获取用户权限总数 当没有时抛出异常
            int sum  = 0;
            try {
                sum = userPrivileges.countPrivileges(roleName, menuName);
            } catch (PrivilegesException e) {
                request.setAttribute("result", e.getErrorMsg());
                request.setAttribute("method","listPrivileges.do?page=1");
                return "fail";
            }

        Map<String,Integer> map = divisionPage(3,page,sum);
            int allPages = map.get("allPages");
            page = map.get("page");

            //按条数获取角色条件记录数
            List<UserPrivileges> allPrivileges =  userPrivileges.listPrivilegesCondition((page - 1) * COUNT,
                                                                                                roleName,
                                                                                                 menuName);
            request.setAttribute("page",page);
            //尾页
            request.setAttribute("allPage",allPages);
            request.setAttribute("listPrivileges",allPrivileges);
            request.setAttribute("roleName",roleName);
            request.setAttribute("menuName", menuName);
            return "success";
    }

    /**
     * 列出角色的所有的权限
     * @param request
     * @param response
     * @return
     */
    public String dolist(HttpServletRequest request, HttpServletResponse response){
        //为角色和菜单的下拉框设置值
        List<Role> listRole = null;
        try {
            listRole = roleService.listRole();
        } catch (RoleException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("listRole",listRole);
        List<Menu> listMenu = menuService.listMenu();
        request.getSession().setAttribute("listMenu",listMenu);
        //每页显示的条数
        int COUNT = 3;
        //用户权限页数
        int page = Integer.parseInt(request.getParameter("page"));
        //获取用户权限总数
        int sum  = userPrivileges.countUserPrivileges();

        Map<String,Integer> map = divisionPage(3,page,sum);
        int allPages = map.get("allPages");
        page = map.get("page");

        //按条数获取角色记录数
        List<UserPrivileges> allPrivileges =  userPrivileges.listLimitUserPrivileges((page - 1) * COUNT);
        request.setAttribute("page",page);
        //尾页
        request.setAttribute("allPage",allPages);
        request.setAttribute("listPrivileges",allPrivileges);
        return "success";
    }


}
