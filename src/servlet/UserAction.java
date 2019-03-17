package servlet;

import beanfactory.BeanFactory;
import entity.User;
import service.UserPrivilegesService;
import service.UserService;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.Random;

public class UserAction {
    private UserService userService = (UserService) BeanFactory.getObject("userservice");
    private UserPrivilegesService userPrivileges = (UserPrivilegesService) BeanFactory.getObject("userprivilegesservice");

    /**
     * 重置用户密码
     *
     * @param request
     * @param response
     * @return
     */
    public String doUpdateUser(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");
        //从session中获取数据
        User user = (User) request.getSession().getAttribute("user");
        //获取用户的账号和密码
        String userAccount = user.getUserAccount();
        String password = user.getUserPwd();
        //从用户输入的数据进行提取
        String oldPwd = request.getParameter("oldPwd");
        String pwd = request.getParameter("pwd");
        String newPwd = request.getParameter("newPwd");
        //不相等时抛出异常
        if (!oldPwd.equals(password)) {
            request.setAttribute("result", "原密码不正确！");
            request.setAttribute("method", "recovery.jsp");
            return "fail";
        }
        //新密码不能与原密码相等
        if (oldPwd.equals(pwd)) {
            request.setAttribute("result", "不能与原密码一样！");
            request.setAttribute("method", "recovery.jsp");
            return "fail";
        }
        //输入的两次密码不一样
        if (!pwd.equals(newPwd)) {
            request.setAttribute("result", "密码不一样！");
            request.setAttribute("method", "recovery.jsp");
            return "fail";
        }
        userService.updateUser(userAccount, pwd);
        request.setAttribute("result", "修改成功，请重新登录！");
        return "success";

    }

    /**
     * 获取验证码
     * @param request
     * @param response
     * @return
     * @throws FileNotFoundException
     */
    public String doCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String code = MakeCertPic.getCertPic(60, 20,response.getOutputStream());
        request.getSession().setAttribute("code", code);
        System.out.println(code);
        return null;
    }

    /**
     * 用于处理用户登录
     *
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    public String doLogin(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String code = request.getParameter("verification");
        String checkCode = (String) request.getSession().getAttribute("code");
        String url = "/manager/login.jsp";
        //进行登录判断
        User user = userService.isUser(userName, password);
//        && checkCode.equalsIgnoreCase(code)
        if (user != null ) {
            request.getSession().setAttribute("user", user);
            //获取用户的权限
            int roleId = Integer.parseInt(user.getRoleId());
            List<String> menuList = userPrivileges.listRoleIdPrivileges(roleId);
            System.out.println(menuList);
            request.setAttribute("menuList", menuList);
            return "success";
        } else {
            return "fail";
        }
    }
}