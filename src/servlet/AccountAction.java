package servlet;

import beanfactory.BeanFactory;
import entity.Account;
import entity.SysConfig;
import entity.User;
import exception.AccountException;
import service.AccountService;
import service.SysConfigService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public class AccountAction {
    private AccountService accountService = (AccountService) BeanFactory.getObject("accountservice");
    private SysConfigService sysConfigService = (SysConfigService) BeanFactory.getObject("sysconfigservice");
    private UserService userService = (UserService) BeanFactory.getObject("userservice");


    public String doSaveAccount(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        //从前台获取信息
        String account = request.getParameter("account");
        String password = request.getParameter("pwd");
        String newPwd = request.getParameter("newPwd");
        String empNo = request.getParameter("empNo");
        String empName = request.getParameter("empName");
        String accountStatus = request.getParameter("accountStatus");
        String roleName = request.getParameter("roleName");
        //进行帐号判断
        if (userService.getUserByAccount(account) != null ){
            request.setAttribute("result", "帐号已存在");
            request.setAttribute("method", "addAccount.jsp");
            return "fail";
        }
        if ("".equals(account)){
            request.setAttribute("result", "帐号不能为空");
            request.setAttribute("method", "addAccount.jsp");
            return "fail";
        }
        if (! password.equals(newPwd)){
            request.setAttribute("result", "输入的密码不一致");
            request.setAttribute("method", "addAccount.jsp");
            return "fail";
        }

        if (userService.getUserByEmpNo(empNo) != null){
            request.setAttribute("result", "员工编号已存在");
            request.setAttribute("method", "addAccount.jsp");
            return "fail";
        }

        if ("".equals(empNo)){
            request.setAttribute("result", "员工编号不能为空");
            request.setAttribute("method", "addAccount.jsp");
            return "fail";
        }
        if ("".equals(empName)){
            request.setAttribute("result", "员工姓名不能为空");
            request.setAttribute("method", "addAccount.jsp");
            return "fail";
        }
        String statusId = sysConfigService.getSysConfigInfo(accountStatus).getConfigKey();
        String roleId = sysConfigService.getSysConfigInfo(roleName).getConfigKey();
        User user = new User();
        user.setEmpName(empName);
        user.setEmpNo(empNo);
        user.setRoleId(roleId);
        user.setAccountStautsId(statusId);
        user.setUserAccount(account);
        user.setUserPwd(password);
        userService.saveUser(user);
        request.setAttribute("result", "添加成功！");
        request.setAttribute("method", "listAccount.do?page=1");
        return "success";
    }

    public String doCheckEmpNo(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        String empNo = request.getParameter("empNo");
        String result = "";
        User user = userService.getUserByEmpNo(empNo);
        if (! "".equals(empNo)){
            if (user != null){
                result = "员工编号已存在！";
            }
        }else {
            result = "员工编号不能为空";
        }
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(result);
        return null;
    }

    /**
     * 判断帐号是否存在
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public String  doCheckAccount(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        String account = request.getParameter("account");
        String result = "";
        User user = userService.getUserByAccount(account);
        if (!"".equals(account)){
            if (user != null){
                result = "该帐号已存在！";
            }
        }else {
            result = "帐号不能为空";
        }
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(result);
        return null;
    }



    /**
     * 通过员工的编号来更新员工信息(user表)
     * @param request
     * @param response
     * @return
     */
    public String doUpdateAccount(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        //先获取帐户信息，防止用户恶意修改员工编号
        Account account = (Account) request.getSession().getAttribute("accountInfo");
        String empNo = account.getEmpNo();
        //获取用户输入的密码
        String password = request.getParameter("pwd");
        String newPwd = request.getParameter("newPwd");
        //如果输入的密码不一致，则报错
        if (! password.equals(newPwd)){
            request.setAttribute("result", "输入的密码不一致");
            request.setAttribute("method","getAccount.do?empNo=" + empNo);
            return "fail";
        }
        //从页面获取状态和角色信息
        String roleName = request.getParameter("roleName");
        String accountStatus = request.getParameter("accountStatus");
        //从配置表获取状态和角色的id
        String roleId = sysConfigService.getSysConfigInfo(roleName).getConfigKey();
        String statusId = sysConfigService.getSysConfigInfo(accountStatus).getConfigKey();
        //将密码、状态、角色存入User
        User user = new User();
        user.setEmpNo(empNo);
        user.setRoleId(roleId);
        user.setAccountStautsId(statusId);
        user.setUserPwd(newPwd);
        userService.updateUserByEmpNo(user);
        request.setAttribute("result", "修改成功！");
        request.setAttribute("method", "listAccount.do?page=1");

        return "success";
    }

    /**
     * 根据员工编号来获取信息
     * @param request
     * @param response
     * @return
     */
    public String doGetAccount(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String empNo = request.getParameter("empNo");
        Account account = accountService.getAccountByEmpNo(empNo);
        //从数据库获取信息并发送给前台
        request.getSession().setAttribute("accountInfo", account);
        request.setAttribute("userAccount", account.getUserAccount());
        request.setAttribute("empNo", account.getEmpNo());
        request.setAttribute("empName", account.getEmpName());
        request.setAttribute("accountStatus", account.getAccountStatus());
        request.setAttribute("roleName", account.getRoleName());
        return "success";
    }



    /**
     * 根据员工编号删除员工帐号
     * 如果帐号为正常状态则不能删除，
     * 只有为注销状态才可以删除
     * @param request
     * @param response
     * @return
     */
    public String doDelAccount(HttpServletRequest request, HttpServletResponse response){
        String empNo = request.getParameter("empNo");
        Account account = accountService.getAccountByEmpNo(empNo);
        if ("正常".equals(account.getAccountStatus())){
            request.setAttribute("result", "该帐号为正常状态，不能删除！");
            request.setAttribute("method", "listAccount.do?page=1");
            return "success";
        }
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
        request.getSession().setAttribute("listRoleName",listRoleName);
        List<SysConfig> listAccountStatus = sysConfigService.listRoleNameOrAccountStatus("account_status_id");
        request.getSession().setAttribute("listAccountStatus",listAccountStatus);
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
