package dao.Impl;

import dao.UserPrivilegesDao;
import entity.RowMapping.UserPrivilegesRowMapping;
import entity.UserPrivileges;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class UserPrivilegesDaoImpl implements UserPrivilegesDao {

    @Override
    public UserPrivileges getRoleIdAndMenuId(String roleName, String menuName) {
        String sql = "SELECT * FROM user_privileges WHERE role_name=? AND menu_name=?";
        List<Object> list = JDBCUtil.executeQuery(sql, new UserPrivilegesRowMapping(), roleName,menuName);
        if(list != null){
            UserPrivileges user = (UserPrivileges) list.get(0);
            return user;
        }
        return null;
    }

    @Override
    public int countPrivilegesCondition(String roleName, String menuName) {
        String sql = "SELECT COUNT(*) FROM user_privileges WHERE role_name=? AND menu_name=?";
        int count = JDBCUtil.executeCountQuery(sql,roleName,menuName);
        return  count;

    }

    @Override
    public List<UserPrivileges> listPrivilegesCondition(int page, String roleName, String menuName) {
        String sql = "SELECT * FROM user_privileges WHERE role_name=? AND menu_name=? LIMIT ?,3";
        List<Object> list = JDBCUtil.executeQuery(sql, new UserPrivilegesRowMapping(), roleName, menuName, page);
        List<UserPrivileges> listPrivilegesCondition = new ArrayList<>();
        if(list != null){
            for(Object obj : list){
                listPrivilegesCondition.add((UserPrivileges) obj);
            }
            return listPrivilegesCondition;
        }
        return null;
    }

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
        System.out.println(dao.getRoleIdAndMenuId("管理员","人事管理"));

    }
}
