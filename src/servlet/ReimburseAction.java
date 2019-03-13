package servlet;

import beanfactory.BeanFactory;
import entity.Reimburse;
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
                int sum = reimburseService.countReimburseByCondition(reimType,reimStatus);
                Map<String,Integer> map = EmpAction.divisionPage(COUNT,page,sum);
                int allPages = map.get("allPages");
                page = map.get("page");

                List<Reimburse> list = reimburseService.listReimburseByCondition((page - 1)*COUNT,reimType,reimStatus);
                request.setAttribute("page",page);
                //尾页
                request.setAttribute("allPage",allPages);
                if(list != null){
                    request.setAttribute("reim",list);
                    request.getSession().setAttribute("reimType",reimType);
                    request.getSession().setAttribute("reimStatus",reimStatus);
                    return "success";
                }
                return "fail";
    }

    public String listReimburse(HttpServletRequest request , HttpServletResponse response){
        //每页显示的条数
        int COUNT = 3;
        //用户页数
        int page = Integer.parseInt(request.getParameter("page"));
        //获取员工总数
        int sum  = reimburseService.listReimburse().size();
        System.out.println("page " + page);
        Map<String,Integer> map = EmpAction.divisionPage(COUNT,page,sum);
        int allPages = map.get("allPages");
        page = map.get("page");

        //按条数获取员工数
        List<Reimburse> allEmp = reimburseService.listReimburseByPage((page - 1) * COUNT);
        request.setAttribute("page",page);
        //尾页
        request.setAttribute("allPage",allPages);
        request.setAttribute("listReimburse",allEmp);
        return "success";
    }
}
