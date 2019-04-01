package servlet;

import beanfactory.BeanFactory;
import entity.Account;
import entity.SysConfig;
import exception.AccountException;
import service.AccountService;
import service.SysConfigService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public class AccountAction {
    private AccountService accountService = (AccountService) BeanFactory.getObject("accountservice");
    private SysConfigService sysConfigService = (SysConfigService) BeanFactory.getObject("sysconfigservice");
    private UserService userService = (UserService) BeanFactory.getObject("userservice");




    /**
     * 根据员工编号删除员工帐号
     * @param request
     * @param response
     * @return
     */
    public String doDelAccount(HttpServletRequest request, HttpServletResponse response){
        String empNo = request.getParameter("empNo");
        userService.deleteUserByEmpNo(empNo);
        request.setAttribute("result", "删除成功");
        request.setAttribute("method", "listAccount.do?page=1");
        return  "success";
    }


    /**
     * 根据条件查询或列出所有的信息
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    public String doListAccount(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        //获取角色名和帐号状态设置下拉框
        List<SysConfig> listRoleName = sysConfigService.listRoleNameOrAccountStatus("role_id");
        request.setAttribute("listRoleName",listRoleName);
        List<SysConfig> listAccountStatus = sysConfigService.listRoleNameOrAccountStatus("account_status_id");
        request.setAttribute("listAccountStatus",listAccountStatus);
        //2.进行分页或列出有的帐号信息
        String account = request.getParameter("account");
        String accountStatus = request.getParameter("accountStatus");
        String roleName = request.getParameter("roleName");

        //定义数据库的列名
        String[] columnName = {"","",""};
        if (! "".equals(account)){
            columnName[0] = "user_account";
        }
        if (! ("请选择".equals(accountStatus) || "".equals(accountStatus))){
            columnName[1] = "account_status";
        }
        if (! ("请选择".equals(roleName) || "".equals(roleName))){
            columnName[2] = "role_name";
        }

        try {
            //根据条件进行查询或列出全部信息的条数
            int sum = accountService.listAccountByConditionOrAll(columnName,false, "%" + account + "%",
                                                                 accountStatus, roleName).size();
            //进行分页
            //每页显示的页数
            int COUNT = 3;
            int page = Integer.parseInt(request.getParameter("page"));
            Map<String,Integer> map = EmpAction.divisionPage(COUNT, page, sum);
            int allPages = map.get("allPages");
            page = map.get("page");
            //根据条件进行查询或列出全部信息
            List<Account> allAccount = accountService.listAccountByConditionOrAll(columnName, true, "%" + account + "%",
                                                                                accountStatus, roleName, (page - 1) * COUNT);
            request.setAttribute("page",page);
            //尾页
            request.setAttribute("allPage",allPages);
            request.setAttribute("listAccount",allAccount);

            //设置原来的值 用于上一页和下一页
            request.setAttribute("account",account);
            request.setAttribute("accountStatus",accountStatus);
            request.setAttribute("roleName", roleName);
            return "success";
        } catch (AccountException e) {
            return "success";
        }
    }
}
