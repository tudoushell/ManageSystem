package servlet;

import beanfactory.BeanFactory;
import entity.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class UserAction {
    private UserService userService = (UserService) BeanFactory.getObject("userservice");
    /**
     * 重置用户密码
     * @param request
     * @param response
     * @return
     */
    public String doUpdateUser(HttpServletRequest request,HttpServletResponse response)
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
        if(! oldPwd.equals(password)){
            request.setAttribute("result","原密码不正确！");
            request.setAttribute("method","recovery.jsp");
            return "fail";
        }
        //新密码不能与原密码相等
        if(oldPwd.equals(pwd)){
            request.setAttribute("result","不能与原密码一样！");
            request.setAttribute("method","recovery.jsp");
            return "fail";
        }
        //输入的两次密码不一样
        if(! pwd.equals(newPwd)){
            request.setAttribute("result","密码不一样！");
            request.setAttribute("method","recovery.jsp");
            return "fail";
        }
        userService.updateUser(userAccount,pwd);
        request.setAttribute("result","修改成功，请重新登录！");
        return "success";

    }
    /**
     * 用于处理用户登录
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    public String doLogin(HttpServletRequest request , HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String url = "/manager/login.jsp";
        //进行登录判断
        User user = userService.isUser(userName,password);
        if(user != null){
            request.getSession().setAttribute("user",user);
            return "success";
        }else {
            return "fail";
        }
    }
}
