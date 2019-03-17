package dao.Impl;

import dao.PermissionsDao;
import entity.Permissions;
import util.JDBCUtil;

import java.sql.Date;

public class PermissionsDaoImpl implements PermissionsDao {


    @Override
    public boolean updatePermissions(int id, String roleId, String menuId) {
        String sql = "UPDATE permissions SET role_id=?,menu_id=? WHERE id=?";
        int flag = JDBCUtil.update(sql,roleId,menuId,id);
        if(flag != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePermByRoleAndMenu(String roleId, String menuId) {
        String sql = "DELETE FROM permissions WHERE role_id=? AND menu_id=?";
        int flag = JDBCUtil.update(sql,roleId,menuId);
        if(flag != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean savePermissions(Permissions perm) {
        String sql = "INSERT INTO permissions (role_id,menu_id,create_time) VALUES(?,?,?)";
        int flag = JDBCUtil.update(sql,perm.getRoleId(),perm.getMenuId(),perm.getCreateTime());
        if(flag != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePermissions(int id) {
        String sql = "DELETE FROM permissions WHERE id=?";
        int flag = JDBCUtil.update(sql,id);
        if (flag != 0){
            return true;
        }
        return false;
    }
}
