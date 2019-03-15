package servlet;

import beanfactory.BeanFactory;
import entity.Employee;
import entity.Menu;
import entity.Role;
import entity.UserPrivileges;
import exception.PrivilegesException;
import service.MenuService;
import service.PermissionsService;
import service.RoleService;
import service.UserPrivilegesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import static servlet.EmpAction.divisionPage;

public class PrivilegesAction {
    private UserPrivilegesService userPrivileges = (UserPrivilegesService) BeanFactory.getObject("userprivilegesservice");
    private RoleService roleService = (RoleService) BeanFactory.getObject("roleservice");
    private MenuService menuService = (MenuService) BeanFactory.getObject("menuservice");
    private PermissionsService permService = (PermissionsService) BeanFactory.getObject("permissionsservice");
    /*
        添加权限步骤
        先从视图中获取角色和菜单的id值，
        然后再根据角色和菜单id写入permission表中
        先去判断角色和菜单的id是否存在，如存在则删除，后添加
     */
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
    public String listPrivilegesByCondition(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
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
        List<Role> listRole = roleService.listRole();
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
