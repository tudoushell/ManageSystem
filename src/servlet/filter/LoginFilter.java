package servlet.filter;

import entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    String[] dologin;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
           //获取局部配置
          String str = filterConfig.getInitParameter("DoLogins");
          dologin = str.split(",");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest) servletRequest;
        User user = (User) hsr.getSession().getAttribute("user");
        String uri = hsr.getRequestURI();
        boolean flag = false;
        for (int i = 0; i < dologin.length; i++) { //dologin出现的网址不进行过滤
                flag = true;
            if (uri.endsWith(dologin[i])){
                flag = false;
            }
        }

        if (flag){  //没有在dologin列表中网址进行过滤
                if (user == null) {
                    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
                    //当未登录时，使用这个语句时，提交的网址仍执行
                  hsr.getRequestDispatcher("/manager/login.jsp").forward(servletRequest,servletResponse);
                    //使用这个时，但会报错
                    //httpServletResponse.sendRedirect("/web/manager/login.jsp");
                }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
