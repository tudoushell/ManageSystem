package dao;

import entity.Role;

import java.util.List;

public interface RoleDao {

    /**
     * 修改角色信息
     * @param role
     */
    boolean updateRole(Role role);
    /**
     * 通过id来删除角色
     * @param roleId
     * @return
     */
    boolean deleteRole(int roleId);
    /**
     * 列出所有角色信息
     * @return
     */
    List<Role> listRole();
}
