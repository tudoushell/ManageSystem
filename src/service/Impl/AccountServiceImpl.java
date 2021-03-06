package service.Impl;

import beanfactory.BeanFactory;
import dao.AccountDao;
import entity.Account;
import exception.AccountException;
import service.AccountService;
import util.Transaction;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = (AccountDao) BeanFactory.getObject("accountdao");
    private Transaction transaction = (Transaction) BeanFactory.getObject("transaction");

    @Override
    public Account getAccountByEmpNo(String empNo) {
        Account account = accountDao.getAccountByEmpNo(empNo);
        return account;
    }

    @Override
    public List<Account> listAccountByConditionOrAll(String[] columnName, boolean flag, Object... args) throws AccountException {
        List<Account> listAccount = accountDao.listAccountByConditionOrAll(columnName, flag, args);
        if (listAccount == null){
            throw new AccountException("没有帐户信息");
        }
        return listAccount;
    }

    public static void main(String[] args) throws AccountException {
        AccountService accountService = new AccountServiceImpl();
        System.out.println(accountService.listAccountByConditionOrAll(new String[]{"account_status","",""},false,"正常","",""));
    }
}
