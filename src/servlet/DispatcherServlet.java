package servlet;

import beanfactory.BeanFactory;
import mvc.ActionConfig;
import mvc.ActionConfigUtil;
import mvc.ResultConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

@WebServlet(name = "Servlet7")
public class DispatcherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //获取未尾地址
            String uri = request.getRequestURI();
            //获取dologin
            String name = uri.substring(uri.lastIndexOf("/") + 1);
            //获取dologin的所有类名有方法名
            ActionConfig actionConfig = ActionConfigUtil.getActionConfig(name);
            //获取类名
            String className = actionConfig.getClassName();
            //获取类名的对象所在的位置并实例化
            Object obj = BeanFactory.getObject(className.toLowerCase());
            //获取方法名
            String method = actionConfig.getMethod();
            try {
                Method methods = obj.getClass().getDeclaredMethod(method,HttpServletRequest.class,HttpServletResponse.class);
                Object result = methods.invoke(obj,request,response);
                if(result == null){
                    return;
                }
                Map<String, ResultConfig> resultConfigMap = actionConfig.getResultConfigMap();
                ResultConfig resultConfig = resultConfigMap.get(result);
                String type = resultConfig.getType();
                String path = resultConfig.getPath();

                if("forward".equals(type)){
//                    response.sendRedirect(path);
                    request.getRequestDispatcher(path).forward(request,response);
                }else {
                    request.getRequestDispatcher(path).forward(request,response);
                }

            }catch (Exception e){
                e.printStackTrace();
            }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
