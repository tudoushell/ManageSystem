package servlet;

import beanfactory.BeanFactory;
import service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountAction {
    private AccountService accountService = (AccountService) BeanFactory.getObject("accountservice");

    public String doListAccount(HttpServletRequest request, HttpServletResponse response){
        return null;
    }
}
