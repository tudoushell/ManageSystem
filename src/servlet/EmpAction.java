package servlet;

import beanfactory.BeanFactory;
import entity.Employee;
import exception.EmpException;
import service.EmpService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpAction {
    private EmpService empService = (EmpService) BeanFactory.getObject("empservice");

    public String doUpdateEmp(HttpServletRequest request , HttpServletResponse response) throws UnsupportedEncodingException {
                request.setCharacterEncoding("UTF-8");
                //从getEmp获取参数
                Employee empl = (Employee) request.getSession().getAttribute("emp");
                String no = empl.getEmpNo();
                String empNo = request.getParameter("empNo");
                String empName = request.getParameter("empName");
                String sex = request.getParameter("sex");
                String empDept = request.getParameter("empDept");
                String entryTime = request.getParameter("entryTime");

                Employee emps = new Employee(empNo,empName,empDept,sex,
                                    null,null,null,
                                            entryTime,empl.getCreateTime());
                if(! no.equals(empNo)){
                    request.setAttribute("result","非法参数！");
                    request.setAttribute("method","getEmp.do?empNo=" + no);
                    return "fail";
                }
                empService.updateEmp(emps);
                request.setAttribute("result","修改成功！");
                request.setAttribute("method","empList.do?page=1");
                return "success";
    }

    public String doGetEmp(HttpServletRequest request , HttpServletResponse response){
            String empNo = request.getParameter("empNo");
            Employee emp = empService.getEmpByNo(empNo);
            request.getSession().setAttribute("emp",emp);
            return "success";
    }


    /**
     * 根据员工号来删除员工信息
     * @param request
     * @param response
     * @return
     */
    public String doDelEmp(HttpServletRequest request , HttpServletResponse response){
        String empNo = request.getParameter("empNo");
        boolean flag = empService.deleteEmp(empNo);
        if(flag){
            request.setAttribute("result","删除成功！");
            request.setAttribute("method","empList.do?page=1");
            return "success";
        }else {
            return "fail";
        }
    }

    /**
     * 添加员工
     * @param request
     * @param response
     * @return
     */
    public  String doAddEmp(HttpServletRequest request , HttpServletResponse response) throws UnsupportedEncodingException{
        request.setCharacterEncoding("UTF-8");
        String empNo = request.getParameter("empNo");
        String empName = request.getParameter("empName");
        String sex = request.getParameter("sex");
        String empDept =request.getParameter("empDept");
        String entryTime = request.getParameter("entryTime");

        Employee emp = new Employee(empNo,empName,empDept,sex,
                         null,null,null,entryTime,
                          new Date(new java.util.Date().getTime()).toString());
        try {
          empService.saveEmps(emp);
            request.setAttribute("result","员工添加成功！");
            request.setAttribute("method", "empList.do?page=1");
            return "success";
        } catch (EmpException e) {
            request.setAttribute("result",e.getErrorMsg());
            request.setAttribute("method", "addEmp.jsp");
            return "fail";
        }

    }



    /**
     * 1.列出所有的员工
     * 2.按条件来列出员工
     * @param request
     * @param response
     * @return
     */
    public String doList(HttpServletRequest request , HttpServletResponse response){
        String result = null;
        //获取员工姓名
        String empName = request.getParameter("empName");
//        System.out.println("****" + empName.length());
        System.out.println("*****" + empName);
        if(!"".equals(empName)){
            result =  doEmpCondition(request,response);
        }else {
            result = listEmp(request,response);
            System.out.println(result);
        }
        return result;
    }

    /**
     * 按条件来列出员工并进行分页
     * @param request
     * @param response
     * @return
     */
    public String doEmpCondition(HttpServletRequest request , HttpServletResponse response){
        String empName = request.getParameter("empName");
        String empDept = request.getParameter("empDept");

        int COUNT = 3;
        int page = Integer.parseInt(request.getParameter("page"));
        int sum = 0;

        //判断异常
        try {
            sum = empService.countEmpByConditions(empName,empDept);
        } catch (EmpException e) {
            request.setAttribute("result", e.getErrorMsg());
            request.setAttribute("method","empList.do?page=1");
            return "fail";
        }

        Map<String,Integer> map = divisionPage(COUNT,page,sum);

        int allPages = map.get("allPages");
        page = map.get("page");

        //按条数获取员工数
        List<Employee> allEmp = empService.listEmpByConditions((page - 1) * COUNT,empName,empDept);
        request.setAttribute("page",page);
        //尾页
        request.setAttribute("allPage",allPages);
        request.setAttribute("listEmp",allEmp);
        //设置原来的值
        request.setAttribute("empNames",empName);
        request.setAttribute("empDepts",empDept);
        return "success";
    }



    /**
     * 列出所有员工
     * @param request
     * @param response
     * @return
     */
    public String listEmp(HttpServletRequest request , HttpServletResponse response){
        //每页显示的条数
        int COUNT = 3;
        //用户页数
        int page = Integer.parseInt(request.getParameter("page"));
        //获取员工总数
        int sum  = empService.listEmps().size();

        Map<String,Integer> map = divisionPage(3,page,sum);
        int allPages = map.get("allPages");
        page = map.get("page");

        //按条数获取员工数
        List<Employee> allEmp = empService.listEmpByPages((page - 1) * COUNT);
        request.setAttribute("page",page);
        //尾页
        request.setAttribute("allPage",allPages);
        request.setAttribute("listEmp",allEmp);
        return "success";
    }




    /*
        工具类
     */
    /**
     *
     * @param count 分页数
     * @param page  用户要的页数
     * @param sum  总共的页数
     * @return
     */
    public static Map<String,Integer> divisionPage(int count , int page , int sum){
            Map<String,Integer> map = new HashMap<>();
            //员工总条数
            int allPages = sum / count + (sum % count ==0 ? 0 : 1);
            //进行页数判断
            if(page < 1){
                page = 1;
            }else if (page > allPages){
                page = allPages;
            }
            map.put("allPages",allPages);
            map.put("page",page);
        return map;
    }
}
