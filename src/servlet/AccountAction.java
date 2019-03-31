package servlet;

import beanfactory.BeanFactory;
import entity.SysConfig;
import service.AccountService;
import service.SysConfigService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class AccountAction {
    private AccountService accountService = (AccountService) BeanFactory.getObject("accountservice");
    private SysConfigService sysConfigService = (SysConfigService) BeanFactory.getObject("sysconfigservice");

    public String doListAccount(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        //1.先获取角色名和帐号状态
        List<SysConfig> listRoleName = sysConfigService.listRoleNameOrAccountStatus("role_id");
        System.out.println(listRoleName);
        request.setAttribute("listRoleName",listRoleName);
        List<SysConfig> listAccountStatus = sysConfigService.listRoleNameOrAccountStatus("account_status_id");
        System.out.println(listAccountStatus);
        request.setAttribute("listAccount",listAccountStatus);
        return "success";
    }
}
