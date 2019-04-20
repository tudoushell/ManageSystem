package servlet;

import beanfactory.BeanFactory;
import entity.Holiday;
import entity.SysConfig;
import entity.User;
import exception.HolidayException;
import service.HolidayService;
import service.SysConfigService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public class HolidayAction {
    private HolidayService holidayService = (HolidayService) BeanFactory.getObject("holidayservice");
    private SysConfigService sysConfigService = (SysConfigService) BeanFactory.getObject("sysconfigservice");


    public String doSaveHoliday(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        //从前台获取数据
        String holidayType = request.getParameter("holidayType");
        String holidayBz = request.getParameter("holidayBz");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String holidayStatus = request.getParameter("holidayStatus");
        //对前台的数据进行判断

        return  null;
    }
    /**
     * 列出请假详细信息
     * @param request
     * @param response
     * @return
     */
    public String doGetHoliday(HttpServletRequest request, HttpServletResponse response){
        String holidayNo = request.getParameter("holidayNo");
        Holiday holiday = holidayService.getHolidayByHolidayNo(holidayNo);
        request.setAttribute("holiday", holiday);
        return "success";
    }
    /**
     * 删除请假信息
     * 管理员、人事可以删除已提交的和草稿
     * 普通用户只能删除请假状态为草稿的
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    public String doDelHoliday(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String holidayNo = request.getParameter("holidayNo");
        Holiday holiday = holidayService.getHolidayByHolidayNo(holidayNo);
        //获取请假状态
        String holidayStatus = holiday.getHolidayStatus();
        //获取用户权限，普通用户不能删除已提交的
        User user = (User) request.getSession().getAttribute("user");
        String roleId = user.getRoleId();
        if ("2".equals(roleId) && "已提交".equals(holidayStatus)){ //普通用户不能删除已提交的
            request.setAttribute("result", "该请假已提交不能删除");
            request.setAttribute("method", "listHoliday.do?page=1");
           return "success";
        }else {
            holidayService.deleteHolidayByHolidayNo(holidayNo);
            request.setAttribute("result", "删除成功");
            request.setAttribute("method", "listHoliday.do?page=1");
            return "success";
        }
    }



    /**
     * 根据条件查询请假信息或全部信息
     * 普通用户只能查看自己的信息
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    public String doListHoliday(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        //1.先从数据库中获取下拉框的值holidayType和holidayStatus
        List<SysConfig> listHolidayType = sysConfigService.listRoleNameOrAccountStatus("holiday_type");
        List<SysConfig> listHolidayStatus = sysConfigService.listRoleNameOrAccountStatus("holiday_status");
        request.getSession().setAttribute("listHolidayType", listHolidayType);
        request.getSession().setAttribute("listHolidayStatus", listHolidayStatus);

        //2.从前台获取用户所选的下拉框值
        String holidayUser = request.getParameter("holidayUser");
        String holidayType = request.getParameter("holidayType");
        String holidayStatus = request.getParameter("holidayStatus");
        //3.获取用户的权限 1:超级管理员 2.普通用户 3. 人事
        User user = (User) request.getSession().getAttribute("user");
        String roleId = user.getRoleId();
        //4.设置数据库的列名，和要查询的值
        String[] columnName = {"","",""};
        if (! ("".equals(holidayUser) || "请选择".equals(holidayUser))){ //用户已输入申请人的值
            columnName[0] = "holiday_user";
        }

        if (! ("".equals(holidayType) || "请选择".equals(holidayType))){ //用户已输入请假类型的值
            columnName[1] = "holiday_type";
        }

        if (! ("".equals(holidayStatus) || "请选择".equals(holidayStatus))){ //用户已输入请假状态的值
            columnName[2] = "holiday_status";
        }
        //5.如果是普通用户只能查询自己的
        if ("2".equals(roleId)){
            columnName[0] = "holiday_user";
            holidayUser = user.getEmpName();
        }

        //6.按条件列出请假数据或所有的数据并进行分页
        try {
            int sum = holidayService.listHolidayByConditionOrAll(columnName,false,
                    "%" + holidayUser + "%" ,holidayType,holidayStatus).size();
            //分页
            int COUNT = 3;
            int page = Integer.parseInt(request.getParameter("page"));
            Map<String,Integer> map = EmpAction.divisionPage(COUNT,page,sum);
            int allPages = map.get("allPages");
            page = map.get("page");

            List<Holiday> listHoliday = holidayService.listHolidayByConditionOrAll(columnName, true,
                    "%" + holidayUser + "%", holidayType, holidayStatus, (page - 1) * COUNT);

            request.setAttribute("page",page);
            //尾页
            request.setAttribute("allPage",allPages);
            if (listHoliday != null){
                request.setAttribute("listHoliday",listHoliday);
                request.setAttribute("holidayUser", holidayUser);
                request.setAttribute("holidayType",holidayType);
                request.setAttribute("holidayStatus",holidayStatus);
            }
        } catch (HolidayException e) {
            e.printStackTrace();
            return "success";
        }
        return "success";
    }
}
