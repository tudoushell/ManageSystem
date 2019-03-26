package dao.Impl;

import dao.RoleDao;
import entity.Role;
import entity.RowMapping.RoleRowMapping;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    @Override
    public boolean updateRole(Role role) {
        String sql = "UPDATE role set role_name=? WHERE id=?";
        int flag = JDBCUtil.update(sql,role.getRoleName(),role.getId());
        if(flag != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRole(int roleId) {
        String sql = "DELETE FROM role where id=?";
        int flag = JDBCUtil.update(sql,roleId);
        if(flag != 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Role> listRole() {
        String sql = "SELECT * FROM role";
        List<Object> list = JDBCUtil.executeQuery(sql, new RoleRowMapping());
        List<Role> listRole = new ArrayList<>();
        if(list != null){
            for (Object obj : list){
                listRole.add((Role) obj);
            }
            return listRole;
        }
        return null;
    }

    public static void main(String[] args) {
        RoleDao roleDao = new RoleDaoImpl();
        System.out.println(roleDao.listRole());
    }
}
