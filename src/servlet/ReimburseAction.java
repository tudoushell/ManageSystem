package servlet;

import beanfactory.BeanFactory;
import entity.Reimburse;
import entity.User;
import exception.ReimburseException;
import service.ReimburseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public class ReimburseAction {
    private ReimburseService reimburseService = (ReimburseService)BeanFactory.getObject("reimburseservice");

    /**
     * 列出报销单的详细信息
     * @param request
     * @param response
     * @return
     */
    public String doDetailReimburse(HttpServletRequest request , HttpServletResponse response){
        String reimNo = request.getParameter("reimNo");
        Reimburse reimburse = reimburseService.getReimburseByReimNo(reimNo);
        request.setAttribute("reims",reimburse);
        return "success";
    }


    public String doUpdateReimburse(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        //从Session中获取，防止用户恶意修改报销编号
        Reimburse reimburse = (Reimburse) request.getSession().getAttribute("reim");
        //获取报销编号
        String reimNo = reimburse.getReimNo();
        //获取报销类型
        String reimType = request.getParameter("reimType");
        if("请选择".equals(reimType)){
            request.setAttribute("result","输入的格式有误！");
            request.setAttribute("method","getReimburse.do?reimNo=" + reimNo);
            return "fail";
        }
        //获取摘要
        String reimAbstract = request.getParameter("reimAbstract");

        //获取金额 输入的不是数字进行判断
        double cost = 0;
        try {
            cost = Double.parseDouble(request.getParameter("cost"));
        }catch (NumberFormatException e){
            request.setAttribute("result","输入的格式有误！");
            request.setAttribute("method","getReimburse.do?reimNo=" + reimNo);
            return "fail";
        }
        //获取提交状态
        String status = request.getParameter("reimStatus");
        if("提交".equals(status)){
            status = "已提交";
        }
        boolean flag = reimburseService.updateReimburse(new Reimburse(reimNo,
                                                                        reimburse.getReimName(),
                                                                        reimType,
                                                                        cost,
                                                                        reimburse.getCreateTime(),
                                                                        status,
                                                                        reimAbstract));
        if(flag){
            request.setAttribute("result","修改成功");
            request.setAttribute("method","listReimburse.do?page=1");
            return "success";
        }
        return null;
    }


    /**
     * 通过报销单号来获取记录
     * @param request
     * @param response
     * @return
     */
    public String doGetReimburse(HttpServletRequest request , HttpServletResponse response){
            String reimNo = request.getParameter("reimNo");
            Reimburse reimburse = reimburseService.getReimburseByReimNo(reimNo);
            request.getSession().setAttribute("reim",reimburse);
            return "success";
    }

    /**
     * 添加报销单
     * @param request
     * @param response
     * @return
     */
    public String doAddReimburse(HttpServletRequest request ,HttpServletResponse response)
            throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");
        User user = (User) request.getSession().getAttribute("user");
        //获取用户名字
        String reimName =  user.getEmpName();

        //设置报销编号
        String reimNo = "BX100" + reimburseService.getReimburseMaxId();

        //获取报销类型
        String reimType = request.getParameter("reimType");
        if("请选择".equals(reimType)){
            request.setAttribute("result","输入的格式有误！");
            request.setAttribute("method","addReimburse.jsp");
            return "fail";
        }

        //获取摘要
        String reimAbstract = request.getParameter("reimAbstract");

        //获取金额 输入的不是数字进行判断
        double cost = 0;
        try {
             cost = Double.parseDouble(request.getParameter("cost"));
        }catch (NumberFormatException e){
            request.setAttribute("result","输入的格式有误！");
            request.setAttribute("method","addReimburse.jsp");
            return "fail";
        }
        //创建时间
        String createTime = new Date(new java.util.Date().getTime()).toString();

        //获取提交状态
        String status = request.getParameter("reimStatus");
        if("提交".equals(status)){
            status = "已提交";
        }
        boolean flag = reimburseService.saveReimburse(new Reimburse(reimNo,
                                                        reimName,
                                                        reimType,
                                                        cost,
                                                        createTime,
                                                        status,
                                                        reimAbstract));
        if(flag){
            request.setAttribute("result","添加成功！");
            request.setAttribute("method","listReimburse.do?page=1");
            return "success";
        }
        return "fail";

    }



    /**
     * 根据报销编号来删除记录
     *      1. 先去判断用户的权限如果是管理员和人事可以对已提交的报销进行删除
     *      2. 普通用户只能对申请状态为草稿进行删除
     * @param request
     * @param response
     * @return
     */
    public String doDelReimburse(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
            request.setCharacterEncoding("utf-8");
            //获取报销编号
            String reimNo = request.getParameter("reimNo");
            //获取用户权限
            User user = (User) request.getSession().getAttribute("user");
            String userRoleId = user.getRoleId();
            //获取报销的申请状态
            Reimburse reimburse = reimburseService.getReimburseByReimNo(reimNo);
            String  reimStatus = reimburse.getReimStatus();
            //普通用户
            if("2".equals(userRoleId) && "草稿".equals(reimStatus)){
                reimburseService.deleteReimburseByReimNo(reimNo);
                request.setAttribute("result","删除成功！");
                request.setAttribute("method","listReimburse.do?page=1");
                return "success";
            }else if("2".equals(userRoleId) && "已提交".equals(reimStatus)){
                request.setAttribute("result","不能删除已提交");
                request.setAttribute("method","listReimburse.do?page=1");
                return "fail";
            }
            //管理员和人事
            if("1".equals(userRoleId) || "3".equals(userRoleId)){
                reimburseService.deleteReimburseByReimNo(reimNo);
                request.setAttribute("result","删除成功！");
                request.setAttribute("method","listReimburse.do?page=1");
                return "success";
            }
            request.setAttribute("result","异常参数");
            request.setAttribute("method","listReimburse.do?page=1");
            return "fail";
    }

    /**
     * 功能：
     *      1.查询记录
     *      2.列出记录
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
     * 查询
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
                sum = "2".equals(userRoleId) ? reimburseService.countReimburseByUser(reimName,reimType,reimStatus):
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

        //获取报销总数 如果是普通用户则获取当前用户的报销数量
        int sum  = "2".equals(userRoleId) ? reimburseService.countReimburseByNames(user.getEmpName()) :
                                            reimburseService.listReimburse().size();
        Map<String,Integer> map = EmpAction.divisionPage(COUNT,page,sum);
        int allPages = map.get("allPages");
        page = map.get("page");

        //按条数获取报销数 如果是普通用户则获取当前用户的报销情况
        List<Reimburse> allEmp = "2".equals(userRoleId) ? reimburseService.listReimburseByNames((page - 1) * COUNT,user.getEmpName()):
                                                                reimburseService.listReimburseByPage((page - 1) * COUNT);
        request.setAttribute("page",page);
        //尾页
        request.setAttribute("allPage",allPages);
        request.setAttribute("listReimburse",allEmp);
        return "success";
    }


}
