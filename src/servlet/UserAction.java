package servlet;

import beanfactory.BeanFactory;
import entity.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class UserAction {
    /**
     * 用于处理用户登录
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    public String doLogin(HttpServletRequest request , HttpServletResponse response) throws UnsupportedEncodingException {
        UserService userService = (UserService) BeanFactory.getObject("userservice");
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String url = "/manager/login.jsp";
        //进行登录判断
        if(userService.isUser(userName,password)){
            request.getSession().setAttribute("user",userName);
            return "success";
        }else {
            return "fail";
        }
    }
}
