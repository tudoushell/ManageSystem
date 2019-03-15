package dao.Impl;

import dao.RoleDao;
import entity.Role;
import entity.RowMapping.RoleRowMapping;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

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
