package servlet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 实现字符过滤
 */

public class CharacterEncodingFilter implements Filter {
    String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            //获取全局配置
            encoding = filterConfig.getServletContext().getInitParameter("CharSet");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取用户提交的方式
        HttpServletRequest serviceMethod = (HttpServletRequest) servletRequest;
        System.out.println(serviceMethod.getMethod());
        //当提交的方式为post时，则设置编码方式
        if(serviceMethod.getMethod().equalsIgnoreCase("post")){
            System.out.println("*****");
            servletRequest.setCharacterEncoding(encoding);
        }else if(serviceMethod.getMethod().equalsIgnoreCase("get")){
                servletRequest = new ResetRequest(serviceMethod);

        }
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("设置字符集结束");
    }

    @Override
    public void destroy() {

    }

    /**
     * HttpServletRequestWrapper extends ServletRequestWrapper implements HttpServletRequest
     */
    class ResetRequest extends HttpServletRequestWrapper{
        HttpServletRequest request;
        public ResetRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        @Override
        public String getParameter(String name){
            String value = request.getParameter(name);
            if(value == null || value.trim().equals("")){
                return "";
            }
            try{
                value = new String(value.getBytes("iso-8859-1"),"UTF-8");

            }catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
            return value;
        }

        @Override
        public String[] getParameterValues(String name) {
            String[] values = request.getParameterValues(name);
            if (values == null || values.length == 0) {
                return null;
            }
            for (int i = 0; i < values.length; i++) {
                try {
                    String value = new String(values[i].getBytes("iso-8859-1"), "UTF-8");
                    values[i] = value;
                } catch (UnsupportedEncodingException e) {
                    values[i] = "";
                    e.printStackTrace();
                }
            }
            return values;
        }

    }
}
