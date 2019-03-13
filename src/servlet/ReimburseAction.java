package servlet;

import beanfactory.BeanFactory;
import entity.Reimburse;
import entity.User;
import exception.ReimburseException;
import service.ReimburseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public class ReimburseAction {
    private ReimburseService reimburseService = (ReimburseService)BeanFactory.getObject("reimburseservice");
    /**
     * 列出并进行分页
     * @param request
     * @param response
     * @return
     */
    public String doListReimburse(HttpServletRequest request , HttpServletResponse response) throws UnsupportedEncodingException {
                request.setCharacterEncoding("utf-8");
                String reimType = request.getParameter("reimType");
                String reimStatus = request.getParameter("reimStatus");
                if (reimType.length() > 0){
                    return listReimburseByCondition(request,response);
                }else{
                    return listReimburse(request,response);
                }
    }

    public String listReimburseByCondition(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
                request.setCharacterEncoding("utf-8");
                int COUNT = 3;
                String reimType = request.getParameter("reimType");
                String reimStatus = request.getParameter("reimStatus");
                int page = Integer.parseInt(request.getParameter("page"));
                int sum = 0;
                try {
                    sum = reimburseService.countReimburseByCondition(reimType,reimStatus);
                } catch (ReimburseException e) {
                    request.setAttribute("result",e.getErrorMsg());
                    request.setAttribute("method","listReimburse.do?page=1");
                    return "fail";
                }

                Map<String,Integer> map = EmpAction.divisionPage(COUNT,page,sum);
                int allPages = map.get("allPages");
                page = map.get("page");

                List<Reimburse> list = reimburseService.listReimburseByCondition((page - 1)*COUNT,reimType,reimStatus);
                request.setAttribute("page",page);
                //尾页
                request.setAttribute("allPage",allPages);

                if(list != null){
                    request.setAttribute("listReimburse",list);
                    request.setAttribute("reimType",reimType);
                    request.setAttribute("reimStatus",reimStatus);
                    return "success";
                }
                return "fail";
    }

    public String listReimburse(HttpServletRequest request , HttpServletResponse response){
        //获取用户的权限 1为管理员 2为普通用户 3.人事专员
        //1.如果为1和3则可以查看所有报销，2只能查看自己的报销情况
        User user = (User) request.getSession().getAttribute("user");
        String userRoleId = user.getRoleId();
        //每页显示的条数
        int COUNT = 3;
        //用户页数
        int page = Integer.parseInt(request.getParameter("page"));

        //获取员工总数 如果是普通用户则获取当前用户的报销数量
        int sum  = "2".equals(userRoleId) ? reimburseService.countReimburseByNames(user.getEmpName()) :
                                            reimburseService.listReimburse().size();
        Map<String,Integer> map = EmpAction.divisionPage(COUNT,page,sum);
        int allPages = map.get("allPages");
        page = map.get("page");

        //按条数获取员工数 如果是普通用户则获取当前用户的报销情况
        List<Reimburse> allEmp = "2".equals(userRoleId) ? reimburseService.listReimburseByNames((page - 1) * COUNT,user.getEmpName()):
                                                                reimburseService.listReimburseByPage((page - 1) * COUNT);
        request.setAttribute("page",page);
        //尾页
        request.setAttribute("allPage",allPages);
        request.setAttribute("listReimburse",allEmp);
        return "success";
    }
}
