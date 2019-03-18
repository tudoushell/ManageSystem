package servlet;

import beanfactory.BeanFactory;
import entity.Department;
import exception.DeptException;
import service.DeptService;
import service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeptAction {
    private DeptService deptService = (DeptService) BeanFactory.getObject("deptservice");
    private EmpService empService = (EmpService) BeanFactory.getObject("empservice");
    /**
     * 修改部门信息
     * @param request
     * @param response
     * @return
     */
    public String doChange(HttpServletRequest request , HttpServletResponse response){
        Department dt = (Department) request.getSession().getAttribute("dt");
        //从查询的数据获取id，防止用户恶意提交
        String deptId = dt.getDeptId();

        String userDeptId = request.getParameter("deptId");
        String deptName = request.getParameter("deptName");
        String deptLoc = request.getParameter("deptLoc");
        String deptLeader = request.getParameter("deptLeader");
        Department newDt = new Department(deptId,deptName,deptLoc,deptLeader);
        if(!deptId.equals(userDeptId)){
            request.setAttribute("result","非法提交");
            request.setAttribute("method","get.do?deptId=" + deptId);
            return "fail";
        }
        deptService.updateDept(newDt);
        request.setAttribute("result","修改成功！");
        return "success";
    }


    /**
     * 获取部门信息
     * @param request
     * @param response
     * @return
     */
    public String doGet(HttpServletRequest request , HttpServletResponse response){
        String deptId = request.getParameter("deptId");
        DeptService deptService = (DeptService) BeanFactory.getObject("deptservice");
        Department dt = deptService.getDept(deptId);
        request.getSession().setAttribute("dt",dt);
        return "success";
    }

    /**
     * 删除部门
     * @param request
     * @param response
     * @return
     */
    public String doDel(HttpServletRequest request , HttpServletResponse response){
        String deptId = request.getParameter("deptId");
        String deptName = request.getParameter("deptName");
        if(! empService.isEmpInDept(deptName)){
            deptService.delDept(deptId);
            request.setAttribute("result","删除成功！");
            request.setAttribute("method","list.do?page=1");
            return "success";
        }else {
            request.setAttribute("result","该部门下有员工，删除失败！");
            request.setAttribute("method","list.do?page=1");
            return "fail";
        }

    }

    /**
     * 添加部门
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */

    public String doAdd(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        String deptid  = request.getParameter("deptid");
        String deptname = request.getParameter("deptname");
        String deptloc = request.getParameter("deptloc");
        String deptleader = request.getParameter("deptleader");
        Department department = new Department(deptid,deptname,deptloc,deptleader);
        //对一些异常进行处理
        try {
            deptService.addDepts(department);
            request.setAttribute("result","部门添加成功！");
            request.setAttribute("method","list.do?page=1");
            return "success";
        } catch (DeptException e) {
            request.setAttribute("result",e.getErrorMsg());
            request.setAttribute("method","addDept.jsp");
            return "fail";
        }
    }


    /**
     * 列出所有的部门
     * @param request
     * @param response
     */
    public  String  doList(HttpServletRequest request , HttpServletResponse response){
            DeptService list = (DeptService) BeanFactory.getObject("deptservice");
            List<Department> deptList = null;
            try{
                deptList = list.listDept();
             }catch (DeptException e){
                e.getErrorMsg();
                return "success";
            }
            //列出所有部门的条数
            int count = deptList.size();
            //列出部门共几页
            int allpage = count / 3 + (count % 3 == 0 ? 0:1);
            int pages = Integer.parseInt(request.getParameter("page"));
            //进行判断，当到小于第一页时，跳转到第1页，最后一页时，同样的方法
            if(pages < 1){
                pages = 1;
            }else if(pages >= allpage){
                pages = allpage;
            }
            //进行查询
        List<Department> listLimit = null;
        try {
            listLimit = list.listDeptByPage((pages -1)*3);
        } catch (DeptException e) {
            e.printStackTrace();
        }
        request.setAttribute("deptLists",listLimit);
            //设置页数和设置当前第几页
            request.setAttribute("page",pages);
            //设置总共多少页和尾页
            request.setAttribute("sum",allpage);
            return "success";

        }
}
