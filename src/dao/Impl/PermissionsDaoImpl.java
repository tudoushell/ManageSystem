package dao.Impl;

import dao.PermissionsDao;
import util.JDBCUtil;

public class PermissionsDaoImpl implements PermissionsDao {

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
