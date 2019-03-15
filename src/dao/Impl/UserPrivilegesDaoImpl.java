package dao.Impl;

import dao.UserPrivilegesDao;
import entity.UserPrivileges;
import entity.UserPrivilegesRowMapping;
import sun.security.krb5.internal.PAData;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class UserPrivilegesDaoImpl implements UserPrivilegesDao {

    @Override
    public int countUserPrivileges() {
        String sql = "SELECT COUNT(*) FROM user_privileges";
        int count = JDBCUtil.executeCountQuery(sql);
        if(count != 0){
            return count;
        }
        return 0;
    }

    @Override
    public List<UserPrivileges> listLimitUserPrivileges(int page) {
        String sql = "SELECT * FROM user_privileges LIMIT ?,3";
        List<Object> list = JDBCUtil.executeQuery(sql,new UserPrivilegesRowMapping(), page);
        List<UserPrivileges> privilegesList = new ArrayList<>();
        if(list != null){
            for(Object obj : list){
                privilegesList.add((UserPrivileges) obj);
            }
            return privilegesList;
        }
        return null;
    }


    public static void main(String[] args) {
        UserPrivilegesDao dao = new UserPrivilegesDaoImpl();
        System.out.println(dao.countUserPrivileges());

    }
}
