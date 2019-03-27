package dao;

import entity.Role;

import java.util.List;

public interface RoleDao {

    /**
     * 通过角色名来获取信息
     * @param roleName
     * @return
     */
    Role getRoleByName(String roleName);
    /**
     * 通过id来获取信息
     * @param roleId
     * @return
     */
    Role getRoleById(int roleId);

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
     * 添加角色
     * @param role
     * @return
     */
    boolean saveRole(Role role);
    /**
     * 列出所有角色信息
     * @return
     */
    List<Role> listRole();
}
