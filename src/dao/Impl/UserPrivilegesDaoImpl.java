package dao.Impl;

import dao.UserPrivilegesDao;
import entity.RowMapping.UserPrivilegesRowMapping;
import entity.UserPrivileges;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserPrivilegesDaoImpl implements UserPrivilegesDao {

    @Override
    public List<UserPrivileges> listPrivilegesByConditionOrAll(String[] columnName, boolean flag, Object... args) {
        String[] copyColumnName = {columnName[0],columnName[1]};
        String sql = "SELECT * FROM user_privileges WHERE 1 = 1";
        for (int i = 0; i < copyColumnName.length; i++) {
            if ("".equals(copyColumnName[i])){
                copyColumnName[i] = "1";
                args[i] = "1";
            }
            sql += " AND " + copyColumnName[i] + " LIKE ?";
        }
        if (flag){
            sql += " limit ?,3";
        }
        List<Object> list = JDBCUtil.executeQuery(sql, new UserPrivilegesRowMapping(), args);
        if (list != null){
            List<UserPrivileges> listPrivileges = new ArrayList<>();
            Iterator<Object> it = list.iterator();
            while (it.hasNext()){
                listPrivileges.add((UserPrivileges) it.next());
            }
            return listPrivileges;
        }
        return null;
    }

    @Override
    public List<String> listRoleIdPrivileges(int roleId) {
        String sql = "SELECT menu_id FROM user_privileges WHERE role_id=?";
        List<Object> list = JDBCUtil.executeData(sql,roleId);
        List<String> listPrivileges = new ArrayList<>();
        if(list != null){
            for(Object obj : list){
                listPrivileges.add((String) obj);
            }
            return listPrivileges;
        }
        return null;
    }

    @Override
    public String getMenuId(String menuName) {
        String sql = "SELECT DISTINCT menu_id from user_privileges where menu_name=?";
        Object menuId = JDBCUtil.executeQueryData(sql,menuName);
        if(menuId != null){
            return (String) menuId;
        }
        return null;
    }

    @Override
    public int getRoleId(String roleName) {
        String sql = "SELECT DISTINCT role_id from user_privileges where role_name=?";
        Object roleId = JDBCUtil.executeQueryData(sql,roleName);
        if(roleId != null){
            return (int) roleId;
        }
        return 0;
    }

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
        System.out.println(dao.listPrivilegesByConditionOrAll(new String[]{"role_name",""},false,"",""));

    }
}
