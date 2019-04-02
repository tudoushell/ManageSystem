package service;

import entity.Account;
import exception.AccountException;
import service.Impl.AccountServiceImpl;

import java.util.List;

public interface AccountService {

    /**
     * 通过员工的编号来获取员工的信息
     * @param empNo
     * @return
     */
    Account getAccountByEmpNo(String empNo);

    /**
     * 根据条件来列出帐户信息或全部信息
     * @param columnName
     * @param flag
     * @param args
     * @return
     */
    List<Account> listAccountByConditionOrAll(String[] columnName, boolean flag, Object ... args) throws AccountException;

    public static void main(String[] args) throws AccountException {
        AccountService a = new AccountServiceImpl();
        System.out.println(a.listAccountByConditionOrAll(new String[]{"","",""}, false, "","",""));
    }
}
