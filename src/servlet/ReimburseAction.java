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
    public String doListReimburse(HttpServletRequest request , HttpServletResponse response)
            throws UnsupportedEncodingException {
                request.setCharacterEncoding("utf-8");
                //根据前台获取的数据来判断是否是查询还是列出所有报销单
                String reimType = request.getParameter("reimType");

                if (reimType.length() > 0){
                    return listReimburseByCondition(request,response);
                }else{
                    return listReimburse(request,response);
                }
    }

    /**
     * 根据条件来列出报销信息
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */

    public String listReimburseByCondition(HttpServletRequest request,HttpServletResponse response)
            throws UnsupportedEncodingException {
            User user = (User) request.getSession().getAttribute("user");
            //获取登录者的权限id和姓名
            String userRoleId = user.getRoleId();
            String reimName = user.getEmpName();
            request.setCharacterEncoding("utf-8");

            int COUNT = 3;
            String reimType = request.getParameter("reimType");
            String reimStatus = request.getParameter("reimStatus");
            int page = Integer.parseInt(request.getParameter("page"));
            int sum = 0;
            List<Reimburse> list = null;
            //如果是普通用户则只能查询自己的报销信息数量，不能查询全部信息
            try {
                sum = "2".equals(userRoleId) ? reimburseService.countReimburseByNames(reimName):
                                            reimburseService.countReimburseByCondition(reimType,reimStatus);
            } catch (ReimburseException e) {
                request.setAttribute("result",e.getErrorMsg());
                request.setAttribute("method","listReimburse.do?page=1");
                return "fail";
            }

            Map<String,Integer> map = EmpAction.divisionPage(COUNT,page,sum);
            int allPages = map.get("allPages");
            page = map.get("page");


            //如果是普通用户则只能查询自己的报销信息，不能查询全部信息
            try {
                list = "2".equals(userRoleId) ? reimburseService.listReimburseByUser((page - 1) * COUNT,
                                                                                            reimName,reimType,reimStatus)
                        : reimburseService.listReimburseByCondition((page - 1) * COUNT,reimType,reimStatus);
            } catch (ReimburseException e) {
                request.setAttribute("result",e.getErrorMsg());
                request.setAttribute("method","listReimburse.do?page=1");
                return "fail";
            }
            //翻页
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

    /**
     * 根据不同的用户权限来列出报销情况
     * @param request
     * @param response
     * @return
     */
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
