package dao.Impl;

import dao.AccountDao;
import entity.Account;
import entity.RowMapping.AccountRowMapping;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    @Override
    public List<Account> listAccountByConditionOrAll(String[] columnName, boolean flag, Object... args) {
        String[] copyColumnName = {columnName[0], columnName[1], columnName[2]};
        String sql = "SELECT id, user_account, emp_name, emp_no, account_status, role_name FROM v_account WHERE 1=1";
        for (int i = 0; i < copyColumnName.length; i++) {
            if ("".equals(copyColumnName[i])){
               copyColumnName[i] = "1";
               args[i] = "1";
            }
            sql += " AND " + copyColumnName[i] + " like ?";
        }
        if (flag){
            sql += " limit ?,3";
        }
        List<Object> list = JDBCUtil.executeQuery(sql, new AccountRowMapping(), args);
        List<Account> listAccount = new ArrayList<>();
        if (list != null){
            Iterator<Object> it = list.iterator();
            while (it.hasNext()){
                listAccount.add((Account) it.next());
            }
        }
        return listAccount;
    }

    public static void main(String[] args) {
        AccountDao accountDao = new AccountDaoImpl();
        System.out.println(accountDao.listAccountByConditionOrAll(new String[]{"","account_status",""},false,"","正常",""));
    }
}
